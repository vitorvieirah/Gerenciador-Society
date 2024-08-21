package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.application.services.CampoService;
import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.infrastructure.mappers.CampoMapper;
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

    @PostMapping
    public ResponseEntity<CampoDto> cadastrar(@RequestBody CampoDto campoDto, UriComponentsBuilder uriBuilder) {
        CampoDto campoResponse = campoService.cadastrar(campoDto);
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("/campo/{id}").buildAndExpand(campoResponse.id()).toUri())
                .body(campoResponse);
    }

    @GetMapping(value = "/consultarEstabelecimento/{id}")
    public ResponseEntity<List<CampoDto>> consultarTodosCamposPorEstabelecimento(@PathVariable Long idEstabelecimento) {
        return ResponseEntity.ok(campoService.buscarPorEstabelecimento(idEstabelecimento));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CampoDto> consultarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(campoService.buscarPorId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CampoDto> alterar(@PathVariable Long id, @RequestBody CampoDto novosDados) {
        return ResponseEntity.ok(campoService.alterar(novosDados, id));
    }

    @DeleteMapping(value = "/id")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        campoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
