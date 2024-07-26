package gerenciadorsociety.application.gateways;

import gerenciadorsociety.domain.usuarios.Administrador;

import java.util.Optional;

public interface AdministradorGateway {
    Optional<Administrador> consultarPorCpf(String cpf);
    Optional<Administrador> consultarPorId(Long id);
    Administrador salvar(Administrador adm);
    void deletar(Long id);

}
