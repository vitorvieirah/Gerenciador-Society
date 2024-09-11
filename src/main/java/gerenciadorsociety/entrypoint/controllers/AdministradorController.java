package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.application.usecases.AdministradorUseCase;
import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
import gerenciadorsociety.entrypoint.mappers.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/administradores")
@AllArgsConstructor
public class AdministradorController {

    private final AdministradorUseCase administradorUseCase;
    private final Mapper<Administrador, AdministradorDto> mapper;

    @PostMapping
    public ResponseEntity<AdministradorDto> cadastrar(@RequestBody AdministradorDto administradorDto) {
        AdministradorDto administradorResponse = mapper.paraDto(administradorUseCase.cadastrar(mapper.paraDomain(administradorDto)));
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("/administrador/{id}").buildAndExpand(administradorResponse.id()).toUri())
                .body(administradorResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AdministradorDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.paraDto(administradorUseCase.consultarPorId(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AdministradorDto> alterar(@RequestBody AdministradorDto novosDados, @PathVariable Long id) {
        return ResponseEntity.ok(mapper.paraDto(administradorUseCase.alterar(mapper.paraDomain(novosDados), id)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        administradorUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
