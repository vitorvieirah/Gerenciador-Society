package gerenciadorsociety.controllers;


import gerenciadorsociety.domains.LocacaoCampo;
import gerenciadorsociety.dtos.AdministradorDto;
import gerenciadorsociety.dtos.LocacaoCampoDto;
import gerenciadorsociety.dtos.LocacaoChurrasqueiraDto;
import gerenciadorsociety.dtos.LocacaoDto;
import gerenciadorsociety.services.AdministradorService;
import gerenciadorsociety.services.LocacaoCampoService;
import gerenciadorsociety.services.LocacaoChurrasqueiraService;
import gerenciadorsociety.services.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/administrador")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorService admService;
    private final LocacaoCampoService locacaoCampoService;
    private final LocacaoChurrasqueiraService locacaoChurrasqueiraService;
    private final LocacaoService locacaoService;

    @PostMapping
    public ResponseEntity<AdministradorDto> cadastrar (@RequestBody AdministradorDto dto, UriComponentsBuilder uriBuilder){
        AdministradorDto admBody = admService.cadastrar(dto);
        var uri = uriBuilder.path("/administrador/{id}").buildAndExpand(admBody.cpf()).toUri();
        return ResponseEntity.created(uri).body(admBody);
    }

    @PostMapping("/administrador/locarcampo")
    public ResponseEntity<LocacaoDto> locarCampo (@RequestBody LocacaoCampoDto dto, UriComponentsBuilder uriBuilder){
        LocacaoDto locacaoBody = locacaoCampoService.locar(dto);
        var uri = uriBuilder.path("/administrador/{id}").buildAndExpand(locacaoBody.getId()).toUri();
        return ResponseEntity.created(uri).body(locacaoBody);
    }

    @PostMapping("/administrador/locarchurrasqueira")
    public ResponseEntity<LocacaoDto> locarChurrasqueira (@RequestBody LocacaoChurrasqueiraDto dto, UriComponentsBuilder uriBuilder){
        LocacaoDto locacaoBody = locacaoChurrasqueiraService.locar(dto);
        var uri = uriBuilder.path("/administrador/{id}").buildAndExpand(locacaoBody.getId()).toUri();
        return ResponseEntity.created(uri).body(locacaoBody);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> cancelarLocacao (@PathVariable("id") Long id){
        locacaoService.cancelar(id);
        return ResponseEntity.noContent().build();
    }
}
