package gerenciadorsociety.application.exceptions.administrador;

public class AdministradorNaoEncontradoExecption extends RuntimeException {

    public AdministradorNaoEncontradoExecption() {
        super("Administrador não encontrado");
    }
}
