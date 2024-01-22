package gerenciadorsociety.controllers;

import gerenciadorsociety.dtos.EstabelecimentoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicio")
@RequiredArgsConstructor
public class PrincipalController {

    private final EstabelecimentoService estabService;

    @GetMapping
    public ResponseEntity<EstabelecimentoDto> buscarPorEstabelecimentos(){
        return ResponseEntity.ok(estabService.getEstab());
    }
}
