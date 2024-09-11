package gerenciadorsociety.application.exceptions.churrasqueira;

public class ChurrasqueiraNaoEcontradaException extends RuntimeException{

    public ChurrasqueiraNaoEcontradaException() {
        super("Churrasqueira não econtrada");
    }
}
