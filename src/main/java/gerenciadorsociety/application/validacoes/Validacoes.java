package gerenciadorsociety.application.validacoes;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Validacoes<D> {

    public void validacaoObjetoPresente(Optional<D> object, String mensage) {
        object.ifPresent(obj -> {
            throw new RuntimeException(mensage);
        });
    }

    public void validacaoObjetoVazio(Optional<D> object, String mensage) {
        if (object.isEmpty())
            throw new RuntimeException(mensage);
    }
}
