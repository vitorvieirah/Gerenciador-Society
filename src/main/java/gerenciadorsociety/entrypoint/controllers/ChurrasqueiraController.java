package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.application.usecases.ChurrasqueiraUseCase;
import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import gerenciadorsociety.entrypoint.mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/churrasqueiras")
@RequiredArgsConstructor
public class ChurrasqueiraController {

    private final ChurrasqueiraUseCase churrasqueiraUseCase;
    private final Mapper<Churrasqueira, ChurrasqueiraDto> mapper;

    @PostMapping
    public ResponseEntity<ChurrasqueiraDto> cadastrarChurrasqueira(@RequestBody ChurrasqueiraDto churrasqueiraDto, UriComponentsBuilder uriBuilder) {
        ChurrasqueiraDto churrasqueiraResponse = mapper.paraDto(churrasqueiraUseCase.cadastrar(mapper.paraDomain(churrasqueiraDto)));
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("churrasqueira/{id}").buildAndExpand(churrasqueiraResponse.id()).toUri())
                .body(churrasqueiraResponse);
    }

    @GetMapping(value = "/buscarPorEstabelecimento/{id}")
    public ResponseEntity<List<ChurrasqueiraDto>> buscarPorEstabelecimento(@PathVariable Long idEstabelecimento) {
        return ResponseEntity.ok(mapper.paraDtos(churrasqueiraUseCase.buscarPorEstabelecimento(idEstabelecimento)));
    }

    @GetMapping(value = "/id")
    public ResponseEntity<ChurrasqueiraDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.paraDto(churrasqueiraUseCase.buscarPorId(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ChurrasqueiraDto> alterar(@PathVariable Long id, @RequestBody ChurrasqueiraDto novosDados) {
        return ResponseEntity.ok(mapper.paraDto(churrasqueiraUseCase.alterar(id, mapper.paraDomain(novosDados))));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        churrasqueiraUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
