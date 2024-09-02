package gerenciadorsociety.application.usecases;

import gerenciadorsociety.application.exceptions.locacao.LocacaoIndisponivelException;
import gerenciadorsociety.application.exceptions.locacao.LocacaoNaoEncontradaException;
import gerenciadorsociety.application.exceptions.locacao.locacaoCampo.JogadorExistenteNaListaException;
import gerenciadorsociety.application.exceptions.locacao.locacaoCampo.JogadorNaoEncontradoNaListaException;
import gerenciadorsociety.application.gateways.LocacaoCampoGateway;
import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.domain.usuarios.Jogador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocacaoCampoService {

    private final LocacaoCampoGateway gateway;
    private final CampoUseCase campoUseCase;
    private final EstabelecimentoUseCase estabelecimentoUseCase;
    private final AdministradorUseCase administradorUseCase;
    private final JogadorUseCase jogadorUseCase;

    public LocacaoCampo locar(LocacaoCampo novaLocacao) {
        Optional<LocacaoCampo> locacaoExistente = gateway.buscarPorHoraLocacao(novaLocacao.getHoraLocacao(), novaLocacao.getDataLocacao(), novaLocacao.getCampo().getNumero());

        locacaoExistente.ifPresent(locacaoCampo -> {
            throw new LocacaoIndisponivelException("campo");
        });

        novaLocacao.setCampo(campoUseCase.buscarPorNumero(novaLocacao.getCampo().getNumero()));

        novaLocacao.setEstabelecimento(estabelecimentoUseCase.consultarPorCnpj(novaLocacao.getEstabelecimento().getCnpj()));

        novaLocacao.setAdministrador(administradorUseCase.consultarPorId(novaLocacao.getAdministrador().getId()));

        novaLocacao.setAtivo(true);
        novaLocacao.setData(LocalDate.now());
        novaLocacao.setListaDeJogadores(new ArrayList<>());

        return gateway.salvar(novaLocacao);
    }

    public List<LocacaoCampo> buscarPorTodos(Long idAdminstrador) {
        return gateway.consultarTodasLocacoesPorAdministrador(idAdminstrador);
    }

    public void deletar(Long id) {
        buscarPorId(id).setAtivo(false);
    }

    public Jogador adicionarJogadorNaLista(Long idLocacao, Long idJogador) {
        LocacaoCampo locacao = buscarPorId(idLocacao);

        locacao.getListaDeJogadores().forEach(jogador -> {
            if (Objects.equals(jogador.getId(), idJogador))
                throw new JogadorExistenteNaListaException();
        });

        Jogador jogador = jogadorUseCase.buscarPorId(idJogador);
        locacao.adicionarJogador(jogador);
        gateway.salvar(locacao);
        return jogador;
    }

    public void removerJogadorDaLista(Long idLocacao, Long idJogador) {
        LocacaoCampo locacao = buscarPorId(idLocacao);

        Optional<Jogador> jogadorDaLista = locacao.getListaDeJogadores().stream()
                .filter(jogador -> Objects.equals(jogador.getId(), idJogador))
                .findFirst();

        if (jogadorDaLista.isEmpty())
            throw new JogadorNaoEncontradoNaListaException();

        locacao.removeJogador(jogadorUseCase.buscarPorId(idJogador));
        gateway.salvar(locacao);
    }

    public LocacaoCampo buscarPorId(Long idLocacao) {
        Optional<LocacaoCampo> locacaoCampo = gateway.buscarPorId(idLocacao);

        if (locacaoCampo.isEmpty())
            throw new LocacaoNaoEncontradaException("campo");

        return locacaoCampo.get();
    }
}
