package gerenciadorsociety.application.exceptions.locacao;

public class LocacaoNaoEncontradaException extends RuntimeException {

    public LocacaoNaoEncontradaException(String tipoLocacao) {
        super("Locação de " + tipoLocacao + " não encontrada");
    }
}
