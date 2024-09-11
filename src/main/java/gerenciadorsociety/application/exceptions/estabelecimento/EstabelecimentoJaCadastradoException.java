package gerenciadorsociety.application.exceptions.estabelecimento;

public class EstabelecimentoJaCadastradoException extends RuntimeException{

    public EstabelecimentoJaCadastradoException() {
        super("Estabelecimenot já cadastrado");
    }
}
