package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.application.services.CampoService;
import gerenciadorsociety.entrypoint.dtos.CampoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
}
