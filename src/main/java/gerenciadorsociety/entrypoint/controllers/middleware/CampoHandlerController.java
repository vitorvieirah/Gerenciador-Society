package gerenciadorsociety.entrypoint.controllers.middleware;

import gerenciadorsociety.application.exceptions.campo.CampoJaCadastradoException;
import gerenciadorsociety.application.exceptions.campo.CampoNaoEncontradoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.campo.BuscarPorEstabelecimentoCampoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.campo.BuscarPorIdCampoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.campo.BuscarPorNumeroCampoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CampoHandlerController {

    private final HttpStatus STATUS_500 = HttpStatus.INTERNAL_SERVER_ERROR;

    @ExceptionHandler(CampoJaCadastradoException.class)
    private ResponseEntity<MensagemErroExceptions> jaCadastradoHandler(CampoJaCadastradoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(CampoNaoEncontradoException.class)
    private ResponseEntity<MensagemErroExceptions> naoEncontradoHandler(CampoNaoEncontradoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(BuscarPorEstabelecimentoCampoException.class)
    private ResponseEntity<MensagemErroExceptions> buscaPorEstabelecimentoHandler(BuscarPorEstabelecimentoCampoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(BuscarPorIdCampoException.class)
    private ResponseEntity<MensagemErroExceptions> buscaPorIdHandler(BuscarPorIdCampoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler
    private ResponseEntity<MensagemErroExceptions> buscaPorNumeroHandler(BuscarPorNumeroCampoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

}
