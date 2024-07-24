package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
import gerenciadorsociety.application.services.AdministradorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/administradores")
@AllArgsConstructor
public class AdministradorController {

    private final AdministradorService administradorService;

    @PostMapping
    public ResponseEntity<AdministradorDto> cadastrar(@RequestBody AdministradorDto dto, UriComponentsBuilder uriBuilder) {
        AdministradorDto admBody = administradorService.cadastrar(dto);
        var uri = uriBuilder.path("/administradores/{id}").buildAndExpand(admBody.cpf()).toUri();
        return ResponseEntity.created(uri).body(admBody);
    }
}
