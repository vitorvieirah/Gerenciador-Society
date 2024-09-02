package gerenciadorsociety.application.exceptions.churrasqueira;

public class ChurrasqueiraJaCadastradaException extends RuntimeException{

    public ChurrasqueiraJaCadastradaException() {
        super("Churrasqueira já cadastrada");
    }
}
