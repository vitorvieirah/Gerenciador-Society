package gerenciadorsociety.entrypoint.controllers.middleware;

import gerenciadorsociety.application.exceptions.dono.DonoJaCadastradoException;
import gerenciadorsociety.application.exceptions.dono.DonoNaoEncontradoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.dono.BuscarPorCpfDonoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.dono.BuscarPorIdDonoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.dono.DeletarDonoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.dono.SalvarDonoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class DonoHandlerController {

    private final HttpStatus STATUS_500 = HttpStatus.INTERNAL_SERVER_ERROR;

    @ExceptionHandler(DonoJaCadastradoException.class)
    private ResponseEntity<MensagemErroExceptions> jaCadastradoHandler(DonoJaCadastradoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(DonoNaoEncontradoException.class)
    private ResponseEntity<MensagemErroExceptions> donoNaoEncotradoHandler(DonoNaoEncontradoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(BuscarPorCpfDonoException.class)
    private ResponseEntity<MensagemErroExceptions> buscarPorCpfDonoHandler(BuscarPorCpfDonoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(BuscarPorIdDonoException.class)
    private ResponseEntity<MensagemErroExceptions> buscarPorIdHandler(BuscarPorIdDonoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(DeletarDonoException.class)
    private ResponseEntity<MensagemErroExceptions> deletarHandler(DeletarDonoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(SalvarDonoException.class)
    private ResponseEntity<MensagemErroExceptions> salvarHandler(SalvarDonoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }
}
