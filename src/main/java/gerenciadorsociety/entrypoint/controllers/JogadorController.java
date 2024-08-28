package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.application.usecases.JogadorUseCase;
import gerenciadorsociety.application.usecases.LocacaoCampoService;
import gerenciadorsociety.domain.usuarios.Jogador;
import gerenciadorsociety.entrypoint.dtos.usuarios.JogadorDto;
import gerenciadorsociety.entrypoint.mappers.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/jogador")
@AllArgsConstructor
public class JogadorController {

    private final JogadorUseCase service;
    private final LocacaoCampoService locacaoCampoService;
    private final Mapper<Jogador, JogadorDto> mapper;

    @PostMapping
    public ResponseEntity<JogadorDto> cadastrar(@RequestBody JogadorDto jogadorDto) {
        JogadorDto response = mapper.paraDto(service.cadastrar(mapper.paraDomain(jogadorDto)));
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("jogador/{id}").buildAndExpand(response.id()).toUri())
                .body(response);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<JogadorDto> entrarNaLista(@PathVariable Long idJogador, @RequestBody Long idLocacao) {
        JogadorDto response = mapper.paraDto(locacaoCampoService.adicionarJogadorNaLista(idLocacao, idJogador));
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("jogador/id").buildAndExpand(response.id()).toUri())
                .body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JogadorDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.paraDto(service.buscarPorId(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<JogadorDto> alterar(@PathVariable Long id, @RequestBody JogadorDto novosDados) {
        return ResponseEntity.ok(mapper.paraDto(service.alterar(mapper.paraDomain(novosDados), id)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> sairDaLista(@PathVariable Long idJogador, @RequestBody Long idLocacao) {
        locacaoCampoService.removerJogadorDaLista(idLocacao, idJogador);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
