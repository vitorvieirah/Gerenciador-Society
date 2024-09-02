package gerenciadorsociety.application.exceptions.locacao;

public class LocacaoIndisponivelException extends RuntimeException {

    public LocacaoIndisponivelException(String tipoLocacao) {
        super("Locacao indiponível nesse horário, data e " + tipoLocacao);
    }
}
