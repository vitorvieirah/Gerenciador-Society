package gerenciadorsociety.application.exceptions;

public class AdministradorExistenteException extends RuntimeException {
    public AdministradorExistenteException() {
        super("Admnistrador já está cadastrado");
    }

    public AdministradorExistenteException(String mesage) {
        super(mesage);
    }
}
