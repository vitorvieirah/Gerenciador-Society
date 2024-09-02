package gerenciadorsociety.application.exceptions.dono;

public class DonoJaCadastradoException extends RuntimeException{

    public DonoJaCadastradoException() {
        super("Dono já cadastrado");
    }
}
