package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.application.services.LocacaoCampoService;
import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoCampoDto;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoDto;
import gerenciadorsociety.entrypoint.mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/locacoes/campo")
@RequiredArgsConstructor
public class LocacaoCampoController {

    private final LocacaoCampoService locacaoCampoService;
    private final Mapper<LocacaoCampo, LocacaoCampoDto> mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<LocacaoCampoDto>> vizualizarLocacaoesCampo(@PathVariable Long idAdministrador) {
        return ResponseEntity.ok(mapper.paraDtos(locacaoCampoService.buscarPorTodos(idAdministrador)));
    }

    @PostMapping
    public ResponseEntity<LocacaoDto> locarCampo(@RequestBody LocacaoCampoDto locacaoCampoDto) {
        LocacaoDto locacaoCampoReponse = mapper.paraDto(locacaoCampoService.locar(mapper.paraDomain(locacaoCampoDto)));
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("locacaoCampo/{id}").buildAndExpand(locacaoCampoReponse.getId()).toUri())
                .body(locacaoCampoReponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> cancelarLocacaoCampo(@PathVariable("id") Long id) {
        locacaoCampoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
