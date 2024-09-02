package gerenciadorsociety.application.exceptions.locacao.locacaoCampo;

public class JogadorNaoEncontradoNaListaException extends RuntimeException {

    public JogadorNaoEncontradoNaListaException() {
        super("Jogador não encontrado na lista");
    }
}
