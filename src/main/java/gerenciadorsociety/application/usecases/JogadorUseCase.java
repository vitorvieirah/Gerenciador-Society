package gerenciadorsociety.application.usecases;

import gerenciadorsociety.application.exceptions.jogador.JogadorJaCadastradoException;
import gerenciadorsociety.application.exceptions.jogador.JogadorNaoEncontradoException;
import gerenciadorsociety.application.gateways.JogadorGateway;
import gerenciadorsociety.domain.usuarios.Jogador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class JogadorUseCase {

    private final JogadorGateway gateway;

    public Jogador cadastrar(Jogador novoJogador) {
        Optional<Jogador> jogadorExistente = gateway.buscarPorId(novoJogador.getId());

        jogadorExistente.ifPresent(jogador -> {
            throw new JogadorJaCadastradoException();
        });

        return gateway.salvar(novoJogador);
    }

    public Jogador buscarPorId(Long id) {
        Optional<Jogador> jogador = gateway.buscarPorId(id);

        if (jogador.isEmpty())
            throw new JogadorNaoEncontradoException();

        return jogador.get();
    }

    public Jogador alterar(Jogador novosDados, Long id) {
        Jogador jogadorExistente = buscarPorId(id);

        jogadorExistente.alterarInformacoes(novosDados);

        return gateway.salvar(jogadorExistente);
    }

    public void deletar(Long id) {
        buscarPorId(id);

        gateway.deletar(id);
    }
}
