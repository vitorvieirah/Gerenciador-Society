package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoCampoDto;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoDto;
import gerenciadorsociety.application.services.JogadorService;
import gerenciadorsociety.application.services.LocacaoCampoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/locacoes/campo")
@RequiredArgsConstructor
public class LocacaoCampoController {

    private final LocacaoCampoService locacaoCampoService;
    private final JogadorService jogadorService;

    @GetMapping
    public ResponseEntity<List<LocacaoCampoDto>> vizualizarLocacaoesCampo() {
        return ResponseEntity.ok(locacaoCampoService.buscarPorTodos());
    }

    @PostMapping
    public ResponseEntity<LocacaoDto> locarCampo(@RequestBody LocacaoCampoDto dto, UriComponentsBuilder uriBuilder) {
        LocacaoDto locacaoCampoReponse = locacaoCampoService.locar(dto);
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("locacaoCampo/{id}").buildAndExpand(locacaoCampoReponse.getId()).toUri())
                .body(locacaoCampoReponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> cancelarLocacaoCampo(@PathVariable("id") Long id) {
        locacaoCampoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{id}/jogadores")
    public ResponseEntity<Void> adicionarJogador(@PathVariable("id") Long id, @RequestBody String nomeJogador) {
        jogadorService.entrarNaLista(id, nomeJogador);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}/jogadores")
    public ResponseEntity<Void> removerJogador(@PathVariable Long id, @RequestBody String nomeJogador) {
        jogadorService.sairDeUmaLista(id, nomeJogador);
        return ResponseEntity.ok().build();
    }
}
