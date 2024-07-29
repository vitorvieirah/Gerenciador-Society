package gerenciadorsociety.entrypoint.controllers;

import gerenciadorsociety.application.services.AdministradorService;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
import gerenciadorsociety.infrastructure.mappers.AdministradorMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/administradores")
@AllArgsConstructor
public class AdministradorController {

    private final AdministradorService administradorService;

    @PostMapping
    public ResponseEntity<AdministradorDto> cadastrar(@RequestBody AdministradorDto administradorDto) {
        AdministradorDto administradorResponse = administradorService.cadastrar(administradorDto);
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("/administrador/{id}").buildAndExpand(administradorResponse.id()).toUri())
                .body(administradorResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AdministradorDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(AdministradorMapper.paraDtoDeDomain(administradorService.consultar(id)));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AdministradorDto> alterar(@RequestBody AdministradorDto administradorDto, @PathVariable Long id){
        return ResponseEntity.ok(administradorService.alterar(administradorDto, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        administradorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
