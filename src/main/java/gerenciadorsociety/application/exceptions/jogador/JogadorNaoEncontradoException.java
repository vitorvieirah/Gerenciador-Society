package gerenciadorsociety.application.exceptions.jogador;

public class JogadorNaoEncontradoException extends RuntimeException{

    public JogadorNaoEncontradoException() {
        super("Jogador não encontrado por id.");
    }
}
