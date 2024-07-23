package gerenciadorsociety.controllers;

import gerenciadorsociety.services.JogadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogador")
@RequiredArgsConstructor
public class JogadorController {

    private final JogadorService jogadorService;

    @PutMapping(value = "/entrarlista/{id}")
    public ResponseEntity<Void> entrarEmUmaLista(@PathVariable("id") Long id, @RequestBody String dto) {
        jogadorService.entrarNaLista(id, dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/sairlista/{id}")
    public ResponseEntity<Void> sairDeUmaLista(@PathVariable Long id, @RequestBody String dto) {
        jogadorService.sairDeUmaLista(id, dto);
        return ResponseEntity.ok().build();
    }
}
