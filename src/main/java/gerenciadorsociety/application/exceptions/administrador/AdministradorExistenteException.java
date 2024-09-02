package gerenciadorsociety.application.exceptions.administrador;

public class AdministradorExistenteException extends RuntimeException {
    public AdministradorExistenteException() {
        super("Admnistrador já está cadastrado");
    }
}
