package gerenciadorsociety.application.gateways;

import gerenciadorsociety.domain.usuarios.Administrador;

import java.util.Optional;

public interface AdministradorGateway {
    Optional<Administrador> consultar(String cpf);
    Administrador salvar(Administrador adm);
}
