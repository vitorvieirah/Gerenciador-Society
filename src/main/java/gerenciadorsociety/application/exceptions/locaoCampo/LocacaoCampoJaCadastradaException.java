package gerenciadorsociety.application.exceptions.locaoCampo;

public class LocacaoCampoJaCadastradaException extends RuntimeException{

    public LocacaoCampoJaCadastradaException() {
        super("Locacao indiponível nesse horário, data, e campo");
    }
}
