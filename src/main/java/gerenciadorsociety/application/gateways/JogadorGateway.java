package gerenciadorsociety.application.gateways;

import gerenciadorsociety.domain.usuarios.Jogador;

import java.util.Optional;

public interface JogadorGateway {
    Jogador salvar(Jogador jogador);

    Optional<Jogador> buscarPorId(Long id);

    void deletar(Long id);
}
