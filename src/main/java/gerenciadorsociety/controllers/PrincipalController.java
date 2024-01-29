package gerenciadorsociety.controllers;

import gerenciadorsociety.dtos.EstabelecimentoDto;
import gerenciadorsociety.services.EstabelecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inicio")
@RequiredArgsConstructor
public class PrincipalController {

    private final EstabelecimentoService estabService;

    @GetMapping
    public ResponseEntity<List<EstabelecimentoDto>> buscarPorEstabelecimentos(){
        return ResponseEntity.ok(estabService.getEstabelecimentos());
    }
}
