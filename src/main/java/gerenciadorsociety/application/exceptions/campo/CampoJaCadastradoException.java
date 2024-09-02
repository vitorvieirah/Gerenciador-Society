package gerenciadorsociety.application.exceptions.campo;

public class CampoJaCadastradoException extends RuntimeException{

    public CampoJaCadastradoException() {
        super("Campo já cadastrado");
    }
}
