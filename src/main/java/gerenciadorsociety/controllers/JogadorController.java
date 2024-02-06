package gerenciadorsociety.controllers;

import gerenciadorsociety.dtos.JogadorDto;
import gerenciadorsociety.services.JogadorService;
import gerenciadorsociety.services.LocacaoChurrasqueiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogador")
@RequiredArgsConstructor
public class JogadorController {

    private final JogadorService jogadorService;

    @PostMapping
    public ResponseEntity<Void> entrarEmUmaLista(JogadorDto dto){
        jogadorService.entrarNaLista(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> sairDeUmaLista(Long id){
        return ResponseEntity.ok().build();
    }
}
