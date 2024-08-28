package gerenciadorsociety.application.exceptions;

public class AdministradorNaoEncontradoExecption extends RuntimeException {

    public AdministradorNaoEncontradoExecption() {
        super("Administrador não encontrado");
    }

    public AdministradorNaoEncontradoExecption(String mesage) {
        super(mesage);
    }
}
