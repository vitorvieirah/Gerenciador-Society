package gerenciadorsociety.entrypoint.controllers.middleware.locacoes.locacaoCampo;

import gerenciadorsociety.application.exceptions.locacao.locacaoCampo.JogadorExistenteNaListaException;
import gerenciadorsociety.application.exceptions.locacao.locacaoCampo.JogadorNaoEncontradoNaListaException;
import gerenciadorsociety.entrypoint.controllers.middleware.MensagemErroExceptions;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.locacao.locacaoCampo.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LocacaoCampoHandlerController {

    private final HttpStatus STATUS_500 = HttpStatus.INTERNAL_SERVER_ERROR;

    @ExceptionHandler(JogadorExistenteNaListaException.class)
    private ResponseEntity<MensagemErroExceptions> jogadorExistenteNaListaHandler(JogadorExistenteNaListaException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(JogadorNaoEncontradoNaListaException.class)
    private ResponseEntity<MensagemErroExceptions> jogadorNaoEncontradoNaListaHandler(JogadorNaoEncontradoNaListaException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(BuscarPorHoraLocacaoException.class)
    private ResponseEntity<MensagemErroExceptions> buscarPorHoraHandler(BuscarPorHoraLocacaoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(BuscarPorIdLocacaoCampoException.class)
    private ResponseEntity<MensagemErroExceptions> buscarPorIdHandler(BuscarPorIdLocacaoCampoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(ConsultarTodasLocacaoesCampoPorAdministradorException.class)
    private ResponseEntity<MensagemErroExceptions> consultarTodasHandler(ConsultarTodasLocacaoesCampoPorAdministradorException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(DeletarLocacaoCampoException.class)
    private ResponseEntity<MensagemErroExceptions> deletarHandler(DeletarLocacaoCampoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(SalvarLocacaoCampoException.class)
    private ResponseEntity<MensagemErroExceptions> salvarHandler(SalvarLocacaoCampoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

}
