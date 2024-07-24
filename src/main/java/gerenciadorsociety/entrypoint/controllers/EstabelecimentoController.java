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
        EstabelecimentoDto estabBody = estabelecimentoService.cadastrar(dto);
        var uri = uriBuilder.path("/dono/estabelecimento/{id}").buildAndExpand(estabBody.cnpj()).toUri();
        return ResponseEntity.created(uri).body(estabBody);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        estabelecimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EstabelecimentoDto>> buscarTodos() {
        return ResponseEntity.ok(estabelecimentoService.getEstabelecimentos());
    }
}