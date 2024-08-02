package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.application.services.DonoService;
import gerenciadorsociety.entrypoint.dtos.usuarios.DonoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/donos")
@RequiredArgsConstructor
public class DonoController {

    private final DonoService donoService;

    @PostMapping
    public ResponseEntity<DonoDto> cadastrar(@RequestBody DonoDto donoDto) {
        DonoDto donoResponse = donoService.cadastrar(donoDto);
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("/dono/{id}").buildAndExpand(donoResponse.id()).toUri())
                .body(donoResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonoDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(donoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonoDto> alterar(@PathVariable Long id, DonoDto novosDados) {
        return ResponseEntity.ok(donoService.alterar(id, novosDados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        donoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
