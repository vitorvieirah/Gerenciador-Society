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

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<LocacaoCampoDto>> vizualizarLocacaoesCampo(@PathVariable Long idAdministrador) {
        return ResponseEntity.ok(locacaoCampoService.buscarPorTodos(idAdministrador));
    }

    @PostMapping
    public ResponseEntity<LocacaoDto> locarCampo(@RequestBody LocacaoCampoDto dto) {
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
}
