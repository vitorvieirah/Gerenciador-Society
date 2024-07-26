package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import gerenciadorsociety.application.services.ChurrasqueiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/churrasqueiras")
@RequiredArgsConstructor
public class ChurrasqueiraController {

    private final ChurrasqueiraService churrasqueiraService;

    @PostMapping
    public ResponseEntity<ChurrasqueiraDto> cadastrarChurrasqueira(@RequestBody ChurrasqueiraDto dto, UriComponentsBuilder uriBuilder) {
        ChurrasqueiraDto churraBody = churrasqueiraService.cadastrar(dto);
        var uri = uriBuilder.path("/churrasqueira/{id}").buildAndExpand(churraBody.id()).toUri();
        return ResponseEntity.created(uri).body(churraBody);
    }
}
