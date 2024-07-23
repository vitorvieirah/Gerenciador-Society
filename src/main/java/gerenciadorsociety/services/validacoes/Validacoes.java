package gerenciadorsociety.services.validacoes;

import java.util.Optional;

public class Validacoes<D> {

    public void validacaoObjetoPresente(Optional<D> object, String mensage){
        object.ifPresent(obj -> {
            throw new RuntimeException(mensage);
        });
    }

    public void validacaoObjetoVazio(Optional<D> object, String mensage){
        if(object.isEmpty())
            throw new RuntimeException(mensage);
    }
}
