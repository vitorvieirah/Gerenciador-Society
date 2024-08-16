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

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<LocacaoChurrasqueiraDto>> vizualizarLocacoesChurrasqueiras(@PathVariable Long idAdministrador) {
        return ResponseEntity.ok(locacaoChurrasqueiraService.buscarPorTodos(idAdministrador));
    }

    @PostMapping
    public ResponseEntity<LocacaoDto> locarChurrasqueira(@RequestBody LocacaoChurrasqueiraDto dto, UriComponentsBuilder uriBuilder) {
        LocacaoDto locacaoChurrasqueiraResponse = locacaoChurrasqueiraService.locar(dto);
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("locacaoChurrasqueira/{id}").buildAndExpand(locacaoChurrasqueiraResponse.getId()).toUri())
                .body(locacaoChurrasqueiraResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> cancelarLocacaoChurrasqueira(@PathVariable("id") Long id) {
        locacaoChurrasqueiraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
