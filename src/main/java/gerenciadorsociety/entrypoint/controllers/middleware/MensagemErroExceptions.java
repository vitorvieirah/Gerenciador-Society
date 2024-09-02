package gerenciadorsociety.entrypoint.controllers.middleware;

import org.springframework.http.HttpStatus;

public record MensagemErroExceptions(HttpStatus status, String mensage) {}
