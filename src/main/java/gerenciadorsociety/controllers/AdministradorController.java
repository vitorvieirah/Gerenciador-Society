package gerenciadorsociety.controllers;


import gerenciadorsociety.domains.Administrador;
import gerenciadorsociety.dtos.AdministradorDto;
import gerenciadorsociety.dtos.LocacaoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/administrador")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorService admService;
    private final LocacaoService locacaoService;
    @PostMapping
    public ResponseEntity<AdministradorDto> cadastrar (@RequestBody AdministradorDto dto, UriComponentsBuilder uriBuilder){
        AdministradorDto admBody = admService.cadastrar(dto);
        var uri = uriBuilder.path("/administrador/{id}").buildAndExpand(admBody.cpf()).toUri();
        return ResponseEntity.created(uri).body(admBody);
    }

    @PostMapping
    public ResponseEntity<LocacaoDto> locarCampo (@RequestBody LocacaoDto dto, UriComponentsBuilder uriBuilder){
        LocacaoDto locacaoBody = locacaoService.locar(dto);
        var uri = uriBuilder.path("/administrador/{id}").buildAndExpand(locacaoBody.getId()).toUri();
        return ResponseEntity.created(uri).body(locacaoBody);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> cancelarLocacao (@PathVariable("id") Long id){
        locacaoService.cancelar(id);
        return ResponseEntity.noContent().build();
    }
}
