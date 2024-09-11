package gerenciadorsociety.application.exceptions.dono;

public class DonoNaoEncontradoException extends RuntimeException{

    public DonoNaoEncontradoException() {
        super("Dono não encontrado");
    }
}
