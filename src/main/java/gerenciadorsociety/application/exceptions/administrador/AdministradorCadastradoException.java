package gerenciadorsociety.application.exceptions.administrador;

public class AdministradorCadastradoException extends RuntimeException {
    public AdministradorCadastradoException() {
        super("Admnistrador já está cadastrado");
    }
}
