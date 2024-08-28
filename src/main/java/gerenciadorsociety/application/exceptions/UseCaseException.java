package gerenciadorsociety.application.exceptions;

public class UseCaseException extends RuntimeException {

    public UseCaseException(String mensage) {
        super(mensage);
    }
}
