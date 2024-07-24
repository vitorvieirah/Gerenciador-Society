package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoChurrasqueiraDto;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoDto;
import gerenciadorsociety.application.services.LocacaoChurrasqueiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/locacoes/churrasqueira")
@RequiredArgsConstructor
public class LocacaoChurrasqueiraController {

    private final LocacaoChurrasqueiraService locacaoChurrasqueiraService;

    @GetMapping
    public ResponseEntity<List<LocacaoChurrasqueiraDto>> vizualizarLocacoesChurrasqueiras() {
        return ResponseEntity.ok(locacaoChurrasqueiraService.buscarPorTodos());
    }

    @PostMapping
    public ResponseEntity<LocacaoDto> locarChurrasqueira(@RequestBody LocacaoChurrasqueiraDto dto, UriComponentsBuilder uriBuilder) {
        LocacaoDto locacaoBody = locacaoChurrasqueiraService.locar(dto);
        var uri = uriBuilder.path("/administrador/{id}").buildAndExpand(locacaoBody.getId()).toUri();
        return ResponseEntity.created(uri).body(locacaoBody);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> cancelarLocacaoChurrasqueira(@PathVariable("id") Long id) {
        locacaoChurrasqueiraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
