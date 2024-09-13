package gerenciadorsociety.entrypoint.controllers.middleware;

import gerenciadorsociety.application.exceptions.administrador.AdministradorCadastradoException;
import gerenciadorsociety.application.exceptions.administrador.AdministradorNaoEncontradoExecption;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.administrador.BuscaAdministradorPorCpfException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.administrador.BuscaAdministradorPorIdException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.administrador.DeletarAdministradorException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.administrador.SalvarAdministradorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdministradorHandlerController {

    private final HttpStatus STATUS_500 = HttpStatus.INTERNAL_SERVER_ERROR;

    @ExceptionHandler(AdministradorCadastradoException.class)
    private ResponseEntity<MensagemErroExceptions> jaCadastradoHandler(AdministradorCadastradoException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(AdministradorNaoEncontradoExecption.class)
    private ResponseEntity<MensagemErroExceptions> naoEncontradoHandler(AdministradorNaoEncontradoExecption execption) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(HttpStatus.NOT_FOUND, execption.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(BuscaAdministradorPorCpfException.class)
    private ResponseEntity<MensagemErroExceptions> erroBuscaPorCpfHandler(BuscaAdministradorPorCpfException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(BuscaAdministradorPorIdException.class)
    private ResponseEntity<MensagemErroExceptions> erroBuscaPorIdHandler(BuscaAdministradorPorIdException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(DeletarAdministradorException.class)
    private ResponseEntity<MensagemErroExceptions> erroDeletarHandler(DeletarAdministradorException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }

    @ExceptionHandler(SalvarAdministradorException.class)
    private ResponseEntity<MensagemErroExceptions> erroSalvarHandler(SalvarAdministradorException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(mensagem.status()).body(mensagem);
    }
}
