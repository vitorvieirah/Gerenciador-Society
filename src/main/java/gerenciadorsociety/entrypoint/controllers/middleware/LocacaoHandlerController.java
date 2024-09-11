package gerenciadorsociety.entrypoint.controllers.middleware;

import gerenciadorsociety.application.exceptions.locacao.LocacaoIndisponivelException;
import gerenciadorsociety.application.exceptions.locacao.LocacaoNaoEncontradaException;
import gerenciadorsociety.application.exceptions.locacao.locacaoCampo.JogadorExistenteNaListaException;
import gerenciadorsociety.application.exceptions.locacao.locacaoCampo.JogadorNaoEncontradoNaListaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LocacaoHandlerController {

    private final HttpStatus STATUS_500 = HttpStatus.INTERNAL_SERVER_ERROR;
    private final HttpStatus STATUS_404 = HttpStatus.NOT_FOUND;

    @ExceptionHandler(JogadorExistenteNaListaException.class)
    private ResponseEntity<MensagemErroExceptions> jogadorExistenteNaListaHandler(JogadorExistenteNaListaException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        MensagemErroExceptions mensagem = new MensagemErroExceptions(status, exception.getMessage());
        return ResponseEntity.status(status).body(mensagem);
    }

    @ExceptionHandler(JogadorNaoEncontradoNaListaException.class)
    private ResponseEntity<MensagemErroExceptions> jogadorNaoEncontradoNaListaHandler(JogadorNaoEncontradoNaListaException exception) {

        MensagemErroExceptions mensagem = new MensagemErroExceptions(status, exception.getMessage());
        return ResponseEntity.status(status).body(mensagem);
    }

    @ExceptionHandler(LocacaoIndisponivelException.class)
    private ResponseEntity<MensagemErroExceptions> locacaoIndisponivelHandler(LocacaoIndisponivelException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(STATUS_500).body(mensagem);
    }

    @ExceptionHandler(LocacaoNaoEncontradaException.class)
    private ResponseEntity<MensagemErroExceptions> locacaoNaoEncontradaHandler(LocacaoNaoEncontradaException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_404, exception.getMessage());
        return ResponseEntity.status(STATUS_404).body(mensagem);
    }
}
