package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.application.services.JogadorService;
import gerenciadorsociety.entrypoint.dtos.usuarios.JogadorDto;
import gerenciadorsociety.infrastructure.mappers.JogadorMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/jogador")
@AllArgsConstructor
public class JogadorController {

    private final JogadorService service;

    @PostMapping
    public ResponseEntity<JogadorDto> cadastrar(@RequestBody JogadorDto jogadorDto) {
        JogadorDto response = service.cadastrar(jogadorDto);
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("estabelecimento/{id}").buildAndExpand(response.id()).toUri())
                .body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JogadorDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(JogadorMapper.paraDto(service.buscarPorId(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<JogadorDto> alterar(@PathVariable Long id, @RequestBody JogadorDto novosDados) {
        return ResponseEntity.ok(service.alterar(novosDados, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
