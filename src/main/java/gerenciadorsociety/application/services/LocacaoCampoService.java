package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
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

    private final LocacaoCampoDataProvider locacaoCampoDataProvider;
    private final CampoService campoService;
    private final EstabelecimentoService estabelecimentoService;
    private final AdministradorService administradorService;
    private final Validacoes<LocacaoCampo> validacoes;
    private final JogadorService jogadorService;

    public LocacaoDto locar(LocacaoCampoDto dto) {
        LocacaoCampo locacao = LocacaoCampoMapper.paraDomainDeDto(dto);
        Optional<LocacaoCampo> locacaoOptional = locacaoCampoDataProvider.buscarPorHoraLocacao(locacao.getHoraLocacao(), locacao.getDataLocacao(), locacao.getCampo().getNumero());
        validacoes.validacaoObjetoPresente(locacaoOptional, "Locação já existe");

        locacao.setCampo(campoService.buscarPorNumero(locacao.getCampo().getNumero()));

        locacao.setEstabelecimento(estabelecimentoService.consultarPorCnpj(dto.getEstabelecimento().cnpj()));

        locacao.setAdministrador(administradorService.consultar(dto.getAdministrador().cpf()));

        locacao.setAtivo(true);
        locacao.setData(LocalDate.now());
        locacao.setListaDeJogadores(new ArrayList<>());

        return LocacaoCampoMapper.paraDtoDeDomain(locacaoCampoDataProvider.salvar(locacao));
    }

    public List<LocacaoCampoDto> buscarPorTodos() {
        return LocacaoCampoMapper.paraDtosDeDomains(locacaoCampoDataProvider.consultarTodos());
    }

    public void deletar(Long id) {
        if (locacaoCampoDataProvider.buscarPorId(id).isPresent())
            locacaoCampoDataProvider.deletar(id);
        else
            throw new RuntimeException("Locação de campo não encontrada para deleção");
    }

    public void entrarNaLista(Long idCampo, Long idJogador) {
        LocacaoCampo locacao = buscarPorId(idCampo);

        locacao.getListaDeJogadores().forEach(jogador -> {
            if(Objects.equals(jogador.getId(), idJogador))
                throw new UseCaseException("Jogador já está na lista");
        });

        locacao.adicionarJogador(jogadorService.buscarPorId(idJogador));
        locacaoCampoDataProvider.salvar(locacao);
    }

    public void sairDeUmaLista(Long idCampo, Long idJogador) {
        LocacaoCampo locacao = buscarPorId(idCampo);
        locacao.removeJogador(jogadorService.buscarPorId(idJogador));
        locacaoCampoDataProvider.salvar(locacao);
    }
}
