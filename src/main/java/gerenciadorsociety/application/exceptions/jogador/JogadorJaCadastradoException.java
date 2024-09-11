package gerenciadorsociety.application.exceptions.jogador;

public class JogadorJaCadastradoException extends RuntimeException{

    public JogadorJaCadastradoException() {
        super("Jogador já cadastrado");
    }
}
