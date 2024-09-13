package gerenciadorsociety.entrypoint.controllers.middleware.locacoes;

import gerenciadorsociety.application.exceptions.locacao.LocacaoIndisponivelException;
import gerenciadorsociety.application.exceptions.locacao.LocacaoNaoEncontradaException;
import gerenciadorsociety.application.exceptions.locacao.locacaoCampo.JogadorExistenteNaListaException;
import gerenciadorsociety.application.exceptions.locacao.locacaoCampo.JogadorNaoEncontradoNaListaException;
import gerenciadorsociety.entrypoint.controllers.middleware.MensagemErroExceptions;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.locacao.locacaoCampo.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LocacaoHandlerController {

    @ExceptionHandler(LocacaoIndisponivelException.class)
    private ResponseEntity<MensagemErroExceptions> locacaoIndisponivelHandler(LocacaoIndisponivelException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(LocacaoNaoEncontradaException.class)
    private ResponseEntity<MensagemErroExceptions> locacaoNaoEncontradaHandler(LocacaoNaoEncontradaException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

}
