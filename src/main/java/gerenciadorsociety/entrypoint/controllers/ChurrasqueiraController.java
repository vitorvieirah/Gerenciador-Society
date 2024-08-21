package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import gerenciadorsociety.application.services.ChurrasqueiraService;
import gerenciadorsociety.infrastructure.mappers.ChurrasqueiraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/churrasqueiras")
@RequiredArgsConstructor
public class ChurrasqueiraController {

    private final ChurrasqueiraService churrasqueiraService;

    @PostMapping
    public ResponseEntity<ChurrasqueiraDto> cadastrarChurrasqueira(@RequestBody ChurrasqueiraDto dto, UriComponentsBuilder uriBuilder) {
        ChurrasqueiraDto churrasqueiraResponse = churrasqueiraService.cadastrar(dto);
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("churrasqueira/{id}").buildAndExpand(churrasqueiraResponse.id()).toUri())
                .body(churrasqueiraResponse);
    }

    @GetMapping(value = "/buscarPorEstabelecimento/{id}")
    public ResponseEntity<List<ChurrasqueiraDto>> buscarPorEstabelecimento(@PathVariable Long idEstabelecimento) {
        return ResponseEntity.ok(churrasqueiraService.buscarPorEstabelecimento(idEstabelecimento));
    }

    @GetMapping(value = "/id")
    public ResponseEntity<ChurrasqueiraDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(churrasqueiraService.buscarPorId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ChurrasqueiraDto> alterar(@PathVariable Long id, @RequestBody ChurrasqueiraDto novosDados) {
        return ResponseEntity.ok(churrasqueiraService.alterar(id, novosDados));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        churrasqueiraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
