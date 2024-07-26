package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.entrypoint.dtos.usuarios.DonoDto;
import gerenciadorsociety.application.services.DonoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
