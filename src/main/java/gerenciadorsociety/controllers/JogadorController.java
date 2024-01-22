package gerenciadorsociety.controllers;

import gerenciadorsociety.domains.Jogador;
import gerenciadorsociety.dtos.JogadorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogador")
@RequiredArgsConstructor
public class JogadorController {

    private final JogadorService jogadorService;

    @PutMapping
    public ResponseEntity entrarEmUmaLista(JogadorDto dto){
        return ResponseEntity.ok(jogadorService.entrarNaLista(dto));
    }
}
