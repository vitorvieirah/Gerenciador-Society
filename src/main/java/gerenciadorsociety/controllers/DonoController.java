package gerenciadorsociety.controllers;

import gerenciadorsociety.domains.Locacao;
import gerenciadorsociety.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/dono")
@RequiredArgsConstructor
public class DonoController {

    private final DonoService donoService;
    private final EstabelecimentoService estabService;
    private final CampoService campoService;
    private final LocacaoService locacaoService;

    @PostMapping
    public ResponseEntity<DonoDto> cadastro (@RequestBody DonoDto dto, UriComponentsBuilder uriBuilder){
        DonoDto donoBody = donoService.cadastrar(dto);
        var uri = uriBuilder.path("/dono/{id}").buildAndExpand(donoBody.cpf()).toUri();
        return ResponseEntity.created(uri).body(donoBody);
    }

    @PostMapping
    public ResponseEntity <EstabelecimentoDto> cadastrarEstabelecimento (@RequestBody EstabelecimentoDto dto, UriComponentsBuilder uriBuilder){
        EstabelecimentoDto estabBody = estabService.cadastrar(dto);
        var uri = uriBuilder.path("/dono/estabelecimento/{id}").buildAndExpand(estabBody.cnpj()).toUri();
        return ResponseEntity.created(uri).body(estabBody);
    }

    @PostMapping
    public ResponseEntity <CampoDto> cadastrarCampos (@RequestBody CampoDto dto, UriComponentsBuilder uriBuilder){
        CampoDto campoBody = campoService.cadastrar(dto);
        var uri = uriBuilder.path("/dono/campo/{id}").buildAndExpand(campoBody.id()).toUri();
        return ResponseEntity.created(uri).body(campoBody);
    }

    @PostMapping
    public ResponseEntity <ChurrasqueiraDto> cadastrarEstabelecimento (@RequestBody ChurrasqueiraDto dto, UriComponentsBuilder uriBuilder){
        ChurrasqueiraDto churraBody = churrasService.cadastrar(dto);
        var uri = uriBuilder.path("/dono/churrasqueira/{id}").buildAndExpand(churraBody.id()).toUri();
        return ResponseEntity.created(uri).body(churraBody);
    }

    @GetMapping
    public ResponseEntity<List<LocacaoDto>> vizualizarLocacoes (){
        return ResponseEntity.ok(locacaoService.getLocacoes());
    }
}
