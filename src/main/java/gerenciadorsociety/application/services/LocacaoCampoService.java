package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.LocacaoCampoGateway;
import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoCampoDto;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoDto;
import gerenciadorsociety.infrastructure.dataprovider.LocacaoCampoDataProvider;
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

        if (locacaoExistente.isEmpty())
            throw new UseCaseException("Locação por hora não encontrada");

        locacao.setCampo(campoService.buscarPorNumero(locacao.getCampo().getNumero()));

        locacao.setEstabelecimento(estabelecimentoService.consultarPorCnpj(dto.getEstabelecimento().cnpj()));

        locacao.setAdministrador(administradorService.consultar(dto.getAdministrador().cpf()));

        locacao.setAtivo(true);
        locacao.setData(LocalDate.now());
        locacao.setListaDeJogadores(new ArrayList<>());

        return LocacaoCampoMapper.paraDtoDeDomain(gateway.salvar(locacao));
    }

    public List<LocacaoCampoDto> buscarPorTodos() {
        return LocacaoCampoMapper.paraDtosDeDomains(gateway.consultarTodos());
    }

    public void deletar(Long id) {
        if (gateway.buscarPorId(id).isPresent())
            gateway.deletar(id);
        else
            throw new RuntimeException("Locação de campo não encontrada para deleção");
    }

    public void adicionarJogadorNaLista(Long idLocacao, Long idJogador) {
        LocacaoCampo locacao = buscarPorId(idLocacao);

        locacao.getListaDeJogadores().forEach(jogador -> {
            if(Objects.equals(jogador.getId(), idJogador))
                throw new UseCaseException("Jogador já está na lista");
        });

        locacao.adicionarJogador(jogadorService.buscarPorId(idJogador));
        gateway.salvar(locacao);
    }

    public void removerJogadorDaLista(Long idCampo, Long idJogador) {
        LocacaoCampo locacao = buscarPorId(idCampo);
        locacao.removeJogador(jogadorService.buscarPorId(idJogador));
        gateway.salvar(locacao);
    }

    public LocacaoCampo buscarPorId(Long idLocacao) {
        Optional<LocacaoCampo> locacaoCampo = gateway.buscarPorId(idLocacao);

        if(locacaoCampo.isEmpty())
            throw new UseCaseException("Locação de campo não encontrada");

        return locacaoCampo.get();
    }
}
