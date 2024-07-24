package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.application.services.CampoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/campos")
@RequiredArgsConstructor
public class CampoController {

    private final CampoService campoService;

    @PostMapping
    public ResponseEntity<CampoDto> cadastrar(@RequestBody CampoDto campoDto, UriComponentsBuilder uriBuilder) {
        CampoDto campoBody = campoService.cadastrar(campoDto);
        var uri = uriBuilder.path("/dono/campo/{id}").buildAndExpand(campoBody.id()).toUri();
        return ResponseEntity.created(uri).body(campoBody);
    }
}
