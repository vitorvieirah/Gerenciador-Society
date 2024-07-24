package gerenciadorsociety.application.services;

import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoCampoDto;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoDto;
import gerenciadorsociety.infrastructure.dataprovider.LocacaoCampoDataProvider;
import gerenciadorsociety.infrastructure.mappers.LocacaoCampoMapper;
import gerenciadorsociety.application.validacoes.Validacoes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocacaoCampoService {

    private final LocacaoCampoDataProvider locacaoCampoDataProvider;
    private final CampoService campoService;
    private final EstabelecimentoService estabelecimentoService;
    private final AdministradorService administradorService;
    private final Validacoes<LocacaoCampo> validacoes;

    public LocacaoDto locar(LocacaoCampoDto dto) {
        LocacaoCampo locacao = LocacaoCampoMapper.paraDomainDeDto(dto);
        Optional<LocacaoCampo> locacaoOptional = locacaoCampoDataProvider.buscarPorHoraLocacao(locacao.getHoraLocacao(), locacao.getDataLocacao(), locacao.getCampo().getNumero());
        validacoes.validacaoObjetoPresente(locacaoOptional, "Locação já existe");

        locacao.setCampo(campoService.buscarPorNumero(locacao.getCampo().getNumero()));

        locacao.setEstabelecimento(estabelecimentoService.consultarPorCnpj(dto.getEstabelecimento().cnpj()));

        locacao.setAdministrador(administradorService.consultar(dto.getAdministrador().cpf()));

        locacao.setAtivo(true);
        locacao.setData(LocalDate.now());

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
}