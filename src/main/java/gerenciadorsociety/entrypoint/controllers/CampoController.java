package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.application.services.CampoService;
import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.entrypoint.mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/campos")
@RequiredArgsConstructor
public class CampoController {

    private final CampoService campoService;
    private final Mapper<Campo, CampoDto> mapper;

    @PostMapping
    public ResponseEntity<CampoDto> cadastrar(@RequestBody CampoDto campoDto, UriComponentsBuilder uriBuilder) {
        CampoDto campoResponse = mapper.paraDto(campoService.cadastrar(mapper.paraDomain(campoDto)));
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("/campo/{id}").buildAndExpand(campoResponse.id()).toUri())
                .body(campoResponse);
    }

    @GetMapping(value = "/consultarEstabelecimento/{id}")
    public ResponseEntity<List<CampoDto>> consultarTodosCamposPorEstabelecimento(@PathVariable Long idEstabelecimento) {
        return ResponseEntity.ok(mapper.paraDtos(campoService.buscarPorEstabelecimento(idEstabelecimento)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CampoDto> consultarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.paraDto(campoService.buscarPorId(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CampoDto> alterar(@PathVariable Long id, @RequestBody CampoDto novosDados) {
        return ResponseEntity.ok(mapper.paraDto(campoService.alterar(mapper.paraDomain(novosDados), id)));
    }

    @DeleteMapping(value = "/id")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        campoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
