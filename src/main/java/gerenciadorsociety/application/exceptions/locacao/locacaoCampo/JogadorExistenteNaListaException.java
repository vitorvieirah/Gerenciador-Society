package gerenciadorsociety.application.exceptions.locacao.locacaoCampo;

public class JogadorExistenteNaListaException extends RuntimeException{

    public JogadorExistenteNaListaException() {
        super("Jogador já está na lista");
    }
}
