package gerenciadorsociety.entrypoint.controllers.middleware.locacoes.locacaoCampo;

import gerenciadorsociety.entrypoint.controllers.middleware.MensagemErroExceptions;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.locacao.locacaoChurrasqueira.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LocacaoChurrasqueiraHandlerController {

    private final HttpStatus STATUS_500 = HttpStatus.INTERNAL_SERVER_ERROR;

    @ExceptionHandler(BuscarLocacaoChurrasqueiraValidacaoException.class)
    private ResponseEntity<MensagemErroExceptions> buscarValidacaoHandler(BuscarLocacaoChurrasqueiraValidacaoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(BuscarPorIdLocacaoChurrasqueiraException.class)
    private ResponseEntity<MensagemErroExceptions> buscarPorIdHandler(BuscarPorIdLocacaoChurrasqueiraException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(ConsultarLocacaoesChurrasqueiraPorAdministradorException.class)
    private ResponseEntity<MensagemErroExceptions> consultarPorAdministradorHandler(ConsultarLocacaoesChurrasqueiraPorAdministradorException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(DeletarLocacaoChurrasqueiraException.class)
    private ResponseEntity<MensagemErroExceptions> deletarHandler(DeletarLocacaoChurrasqueiraException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(SalvarLocacaoChurrasqueiraException.class)
    private ResponseEntity<MensagemErroExceptions> salvarHandler(SalvarLocacaoChurrasqueiraException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

}
