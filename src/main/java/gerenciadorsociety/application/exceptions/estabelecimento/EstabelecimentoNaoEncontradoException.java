package gerenciadorsociety.application.exceptions.estabelecimento;

public class EstabelecimentoNaoEncontradoException extends RuntimeException{

    public EstabelecimentoNaoEncontradoException() {
        super("Estabelecimento não encontrado");
    }
}
