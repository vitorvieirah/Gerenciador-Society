package gerenciadorsociety.entrypoint.controllers.middleware;

import gerenciadorsociety.application.exceptions.churrasqueira.ChurrasqueiraJaCadastradaException;
import gerenciadorsociety.application.exceptions.churrasqueira.ChurrasqueiraNaoEcontradaException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.churrasqueira.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ChurrasqueiraHandlerController {

    private final HttpStatus STATUS_500 = HttpStatus.INTERNAL_SERVER_ERROR;

    @ExceptionHandler(ChurrasqueiraJaCadastradaException.class)
    private ResponseEntity<MensagemErroExceptions> jaCadastradoHandler(ChurrasqueiraJaCadastradaException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        MensagemErroExceptions mensagem = new MensagemErroExceptions(status, exception.getMessage());
        return ResponseEntity.status(status).body(mensagem);
    }

    @ExceptionHandler(ChurrasqueiraNaoEcontradaException.class)
    private ResponseEntity<MensagemErroExceptions> naoEncontradoHandler(ChurrasqueiraNaoEcontradaException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        MensagemErroExceptions mensagem = new MensagemErroExceptions(status, exception.getMessage());
        return ResponseEntity.status(status).body(mensagem);
    }

    @ExceptionHandler(BuscarPorEstabelecimentoChurrasqueiraException.class)
    private ResponseEntity<MensagemErroExceptions> buscarPorEstabelecimentoHandler(BuscarPorEstabelecimentoChurrasqueiraException exception){
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(STATUS_500).body(mensagem);
    }

    @ExceptionHandler(BuscarPorIdChurrasqueiraException.class)
    private ResponseEntity<MensagemErroExceptions> buscarPorIdHandler(BuscarPorIdChurrasqueiraException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(STATUS_500).body(mensagem);
    }

    @ExceptionHandler(BuscarPorNumeroChurrasqueiraException.class)
    private ResponseEntity<MensagemErroExceptions> buscarPorNumeroHandler(BuscarPorNumeroChurrasqueiraException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(STATUS_500).body(mensagem);
    }

    @ExceptionHandler(DeletarChurrasqueiraException.class)
    private ResponseEntity<MensagemErroExceptions> deletarHandler(DeletarChurrasqueiraException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(STATUS_500).body(mensagem);
    }

    @ExceptionHandler(SalvarChurrasqueiraException.class)
    private ResponseEntity<MensagemErroExceptions> salvarHandler(SalvarChurrasqueiraException exception) {
        MensagemErroExceptions mensagem = new MensagemErroExceptions(STATUS_500, exception.getMessage());
        return ResponseEntity.status(STATUS_500).body(mensagem);
    }

}
