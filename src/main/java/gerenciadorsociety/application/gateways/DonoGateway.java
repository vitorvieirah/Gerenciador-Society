package gerenciadorsociety.application.gateways;

import gerenciadorsociety.domain.usuarios.Dono;

import java.util.Optional;

public interface DonoGateway {
    Dono salvar(Dono dono);
    Optional<Dono> buscarPorCpf(String cpf);
    void deletar(Long id);
    Optional<Dono> buscarPorId(Long id);
}
