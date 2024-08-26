package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.application.services.DonoService;
import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.entrypoint.dtos.usuarios.DonoDto;
import gerenciadorsociety.entrypoint.mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/donos")
@RequiredArgsConstructor
public class DonoController {

    private final DonoService donoService;
    private final Mapper<Dono, DonoDto> mapper;

    @PostMapping
    public ResponseEntity<DonoDto> cadastrar(@RequestBody DonoDto donoDto) {
        DonoDto donoResponse = mapper.paraDto(donoService.cadastrar(mapper.paraDomain(donoDto)));
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("/dono/{id}").buildAndExpand(donoResponse.id()).toUri())
                .body(donoResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DonoDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.paraDto(donoService.buscarPorId(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DonoDto> alterar(@PathVariable Long id, DonoDto novosDados) {
        return ResponseEntity.ok(mapper.paraDto(donoService.alterar(id, mapper.paraDomain(novosDados))));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        donoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
