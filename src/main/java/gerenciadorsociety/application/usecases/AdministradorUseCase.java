package gerenciadorsociety.application.usecases;

import gerenciadorsociety.application.exceptions.AdministradorExistenteException;
import gerenciadorsociety.application.exceptions.AdministradorNaoEncontradoExecption;
import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.AdministradorGateway;
import gerenciadorsociety.domain.usuarios.Administrador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdministradorUseCase {

    private final AdministradorGateway administradorGateway;

    public Administrador cadastrar(Administrador novoAdministrador) {
        Optional<Administrador> administradorExistente = administradorGateway.consultarPorCpf(novoAdministrador.getCpf());
        administradorExistente.ifPresent(adm -> {
            throw new AdministradorExistenteException();
        });
        return administradorGateway.salvar(novoAdministrador);
    }

    public Administrador consultarPorId(Long id) {
        Optional<Administrador> resultQuery = administradorGateway.consultarPorId(id);
        if (resultQuery.isEmpty())
            throw new AdministradorNaoEncontradoExecption();
        return resultQuery.get();
    }

    public Administrador alterar(Administrador novosDados, Long id) {
        Administrador administradorExistente = consultarPorId(id);
        administradorExistente.setInformacoes(novosDados);

        return administradorGateway.salvar(administradorExistente);
    }

    public void deletar(Long id) {
        consultarPorId(id);
        administradorGateway.deletar(id);
    }
}
