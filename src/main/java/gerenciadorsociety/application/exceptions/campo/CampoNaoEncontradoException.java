package gerenciadorsociety.application.exceptions.campo;

public class CampoNaoEncontradoException extends RuntimeException{

    public CampoNaoEncontradoException() {
        super("Campo não econtrado");
    }
}
