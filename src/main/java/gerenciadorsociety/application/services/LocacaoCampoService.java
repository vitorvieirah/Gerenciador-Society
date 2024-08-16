package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.LocacaoCampoGateway;
import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.domain.usuarios.Jogador;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoCampoDto;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoDto;
import gerenciadorsociety.entrypoint.dtos.usuarios.JogadorDto;
import gerenciadorsociety.infrastructure.mappers.JogadorMapper;
import gerenciadorsociety.infrastructure.mappers.LocacaoCampoMapper;
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
    private final CampoService campoService;
    private final EstabelecimentoService estabelecimentoService;
    private final AdministradorService administradorService;
    private final JogadorService jogadorService;

    public LocacaoDto locar(LocacaoCampoDto dto) {
        LocacaoCampo locacao = LocacaoCampoMapper.paraDomainDeDto(dto);
        Optional<LocacaoCampo> locacaoExistente = gateway.buscarPorHoraLocacao(locacao.getHoraLocacao(), locacao.getDataLocacao(), locacao.getCampo().getNumero());

        locacaoExistente.ifPresent(locacaoCampo -> {
            throw new UseCaseException("Locacao indiponível nesse horário, data, e campo");
        });

        locacao.setCampo(campoService.buscarPorNumero(locacao.getCampo().getNumero()));

        locacao.setEstabelecimento(estabelecimentoService.consultarPorCnpj(dto.getEstabelecimento().cnpj()));

        locacao.setAdministrador(administradorService.consultarPorId(dto.getAdministrador().id()));

        locacao.setAtivo(true);
        locacao.setData(LocalDate.now());
        locacao.setListaDeJogadores(new ArrayList<>());

        return LocacaoCampoMapper.paraDtoDeDomain(gateway.salvar(locacao));
    }

    public List<LocacaoCampoDto> buscarPorTodos(Long idAdminstrador) {
        return LocacaoCampoMapper.paraDtosDeDomains(gateway.consultarTodasLocacoesPorAdministrador(idAdminstrador));
    }

    public void deletar(Long id) {
        buscarPorId(id).setAtivo(false);
    }

    public JogadorDto adicionarJogadorNaLista(Long idLocacao, Long idJogador) {
        LocacaoCampo locacao = buscarPorId(idLocacao);

        locacao.getListaDeJogadores().forEach(jogador -> {
            if (Objects.equals(jogador.getId(), idJogador))
                throw new UseCaseException("Jogador já está na lista");
        });

        Jogador jogador = jogadorService.buscarPorId(idJogador);
        locacao.adicionarJogador(jogador);
        gateway.salvar(locacao);
        return JogadorMapper.paraDto(jogador);
    }

    public void removerJogadorDaLista(Long idLocacao, Long idJogador) {
        LocacaoCampo locacao = buscarPorId(idLocacao);

        Optional<Jogador> jogadorDaLista = locacao.getListaDeJogadores().stream()
                .filter(jogador -> Objects.equals(jogador.getId(), idJogador))
                .findFirst();

        if(jogadorDaLista.isEmpty())
            throw new UseCaseException("Jogador não encontrado na lista");

        locacao.removeJogador(jogadorService.buscarPorId(idJogador));
        gateway.salvar(locacao);
    }

    public LocacaoCampo buscarPorId(Long idLocacao) {
        Optional<LocacaoCampo> locacaoCampo = gateway.buscarPorId(idLocacao);

        if (locacaoCampo.isEmpty())
            throw new UseCaseException("Locação de campo não encontrada");

        return locacaoCampo.get();
    }
}
