package gerenciadorsociety.application.usecases;

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

    private static final String MENSAGEM_ADMINISTRADOR_EXISTE = "Admnistrador já está cadastrado";
    private static final String MENSAGEM_ADMINSITRADOR_NAO_ENCONTRADO = "Administrador não encontrado";

    public Administrador cadastrar(Administrador novoAdministrador) {
        Optional<Administrador> administradorExistente = administradorGateway.consultarPorCpf(novoAdministrador.getCpf());
        administradorExistente.ifPresent(adm -> {
            throw new UseCaseException(MENSAGEM_ADMINISTRADOR_EXISTE);
        });
        return administradorGateway.salvar(novoAdministrador);
    }

    public Administrador consultarPorId(Long id) {
        Optional<Administrador> resultQuery = administradorGateway.consultarPorId(id);
        if (resultQuery.isEmpty())
            throw new UseCaseException(MENSAGEM_ADMINSITRADOR_NAO_ENCONTRADO);
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
