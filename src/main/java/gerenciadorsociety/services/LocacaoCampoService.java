package gerenciadorsociety.services;

import gerenciadorsociety.domains.*;
import gerenciadorsociety.dtos.LocacaoCampoDto;
import gerenciadorsociety.dtos.LocacaoDto;
import gerenciadorsociety.infra.dataprovider.LocacaoCampoDataProvider;
import gerenciadorsociety.infra.mappers.LocacaoCampoMapper;
import gerenciadorsociety.services.validacoes.Validacoes;
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
        validacoes.validacaoCadastro(locacaoOptional, "Locação já existe");

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
}
