package gerenciadorsociety.entrypoint.controllers.middleware;

import gerenciadorsociety.application.exceptions.jogador.JogadorJaCadastradoException;
import gerenciadorsociety.application.exceptions.jogador.JogadorNaoEncontradoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.jogador.BuscarPorIdJogadorException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.jogador.DeletarJogadorException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.jogador.SalvarJogadorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JogadorHandlerController {

    private final HttpStatus STATUS_500 = HttpStatus.INTERNAL_SERVER_ERROR;

    @ExceptionHandler(JogadorJaCadastradoException.class)
    private ResponseEntity<MensagemErroExceptions> jaCadastradoHandler(JogadorJaCadastradoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(JogadorNaoEncontradoException.class)
    private ResponseEntity<MensagemErroExceptions> naoEncontrado(JogadorNaoEncontradoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(BuscarPorIdJogadorException.class)
    private ResponseEntity<MensagemErroExceptions> buscarPorId(BuscarPorIdJogadorException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(DeletarJogadorException.class)
    private ResponseEntity<MensagemErroExceptions> deletarHandler(DeletarJogadorException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(SalvarJogadorException.class)
    private ResponseEntity<MensagemErroExceptions> salvarJogadorHandler(SalvarJogadorException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }
}