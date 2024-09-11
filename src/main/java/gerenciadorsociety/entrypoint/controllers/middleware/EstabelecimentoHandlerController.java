package gerenciadorsociety.entrypoint.controllers.middleware;

import gerenciadorsociety.application.exceptions.estabelecimento.EstabelecimentoJaCadastradoException;
import gerenciadorsociety.application.exceptions.estabelecimento.EstabelecimentoNaoEncontradoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.estabelecimento.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EstabelecimentoHandlerController {

    private final HttpStatus STATUS_500 = HttpStatus.INTERNAL_SERVER_ERROR;

    @ExceptionHandler(EstabelecimentoJaCadastradoException.class)
    private ResponseEntity<MensagemErroExceptions> jaCadastradoHandler(EstabelecimentoJaCadastradoException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        MensagemErroExceptions mensagem = new MensagemErroExceptions(status, exception.getMessage());
        return ResponseEntity.status(status).body(mensagem);
    }

    @ExceptionHandler(EstabelecimentoNaoEncontradoException.class)
    private ResponseEntity<MensagemErroExceptions> naoEncontradoHandler(EstabelecimentoNaoEncontradoException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        MensagemErroExceptions mensagem = new MensagemErroExceptions(status, exception.getMessage());
        return ResponseEntity.status(status).body(mensagem);
    }

    @ExceptionHandler(ConsultarPorCnpjEstabelecimentoException.class)
    private ResponseEntity<MensagemErroExceptions> consultarPorCnjHandler(ConsultarPorCnpjEstabelecimentoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(STATUS_500).body(mensagem);
    }

    @ExceptionHandler(ConsultarPorIdEstabelecimentoException.class)
    private ResponseEntity<MensagemErroExceptions> consultarPorIdHandler(ConsultarPorIdEstabelecimentoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(STATUS_500).body(mensagem);
    }

    @ExceptionHandler(ConsultarTodosEstabelecimentosException.class)
    private ResponseEntity<MensagemErroExceptions> consultarTodosHandler(ConsultarTodosEstabelecimentosException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(STATUS_500).body(mensagem);
    }

    @ExceptionHandler(DeletarEstabelecimentoException.class)
    private ResponseEntity<MensagemErroExceptions> deletarHandler(DeletarEstabelecimentoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(STATUS_500).body(mensagem);
    }

    @ExceptionHandler(SalvarEstabelecimentoException.class)
    private ResponseEntity<MensagemErroExceptions> salvarHandler(SalvarEstabelecimentoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(STATUS_500).body(mensagem);
    }
}
