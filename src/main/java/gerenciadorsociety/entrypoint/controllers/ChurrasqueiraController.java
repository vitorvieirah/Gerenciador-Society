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
        ChurrasqueiraDto churrasqueiraResponse = churrasqueiraService.cadastrar(dto);
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("churrasqueira/{id}").buildAndExpand(churrasqueiraResponse.id()).toUri())
                .body(churrasqueiraResponse);
    }
}
