package gerenciadorsociety.entrypoint.controllers.middleware;

import gerenciadorsociety.application.exceptions.dono.DonoJaCadastradoException;
import gerenciadorsociety.application.exceptions.dono.DonoNaoEncontradoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.dono.BuscarPorCpfDonoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class DonoHandlerController {

    private final HttpStatus STATUS_500 = HttpStatus.INTERNAL_SERVER_ERROR;
    @ExceptionHandler(DonoJaCadastradoException.class)
    private ResponseEntity<MensagemErroExceptions> jaCadastradoHandler(DonoJaCadastradoException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        MensagemErroExceptions mensagem = new MensagemErroExceptions(status, exception.getMessage());
        return ResponseEntity.status(status).body(mensagem);
    }

    @ExceptionHandler(DonoNaoEncontradoException.class)
    private ResponseEntity<MensagemErroExceptions> donoNaoEncotradoHandler(DonoNaoEncontradoException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        MensagemErroExceptions mensagem = new MensagemErroExceptions(status, exception.getMessage());
        return ResponseEntity.status(status).body(mensagem);
    }

    @ExceptionHandler(BuscarPorCpfDonoException.class)
    private ResponseEntity<MensagemErroExceptions> buscarPorCofDono(BuscarPorCpfDonoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(STATUS_500).body(mensagem);
    }
}
