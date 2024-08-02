package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import gerenciadorsociety.application.services.EstabelecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/estabelecimentos")
@RequiredArgsConstructor
public class EstabelecimentoController {

    private final EstabelecimentoService estabelecimentoService;

    @PostMapping
    public ResponseEntity<EstabelecimentoDto> cadastrar(@RequestBody EstabelecimentoDto dto, UriComponentsBuilder uriBuilder) {
        EstabelecimentoDto estabelecimentoResponse = estabelecimentoService.cadastrar(dto);
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("estabelecimento/{id}").buildAndExpand(estabelecimentoResponse.id()).toUri())
                .body(estabelecimentoResponse);
    }

    @GetMapping
    public ResponseEntity<List<EstabelecimentoDto>> buscarTodos() {
        return ResponseEntity.ok(estabelecimentoService.getEstabelecimentos());
    }

    @PutMapping()

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        estabelecimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
