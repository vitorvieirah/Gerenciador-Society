package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.application.services.EstabelecimentoService;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import gerenciadorsociety.entrypoint.mappers.Mapper;
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
    private final Mapper<Estabelecimento, EstabelecimentoDto> mapper;

    @PostMapping
    public ResponseEntity<EstabelecimentoDto> cadastrar(@RequestBody EstabelecimentoDto estabelecimentoDto) {
        EstabelecimentoDto estabelecimentoResponse = mapper.paraDto(estabelecimentoService.cadastrar(mapper.paraDomain(estabelecimentoDto)));
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("estabelecimento/{id}").buildAndExpand(estabelecimentoResponse.id()).toUri())
                .body(estabelecimentoResponse);
    }

    @GetMapping
    public ResponseEntity<List<EstabelecimentoDto>> buscarTodos() {
        return ResponseEntity.ok(mapper.paraDtos(estabelecimentoService.getEstabelecimentos()));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EstabelecimentoDto> alterar(@RequestBody EstabelecimentoDto novosDados, @PathVariable Long id) {
        return ResponseEntity.ok(mapper.paraDto(estabelecimentoService.alterar(mapper.paraDomain(novosDados), id)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        estabelecimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
