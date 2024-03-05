package gerenciadorsociety.services;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.domains.LocacaoCampo;
import gerenciadorsociety.dtos.LocacaoCampoDto;
import gerenciadorsociety.dtos.LocacaoDto;
import gerenciadorsociety.infra.dataprovider.CampoDataProvider;
import gerenciadorsociety.infra.dataprovider.LocacaoCampoDataProvider;
import gerenciadorsociety.infra.mappers.LocacaoCampoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocacaoCampoService {

    private final LocacaoCampoDataProvider locacaoCampoDataProvider;
    private final CampoDataProvider campoDataProvider;

    private static final String MENSAGEM_LOCACAO_JA_LOCADA = "Locação já existe";

    public LocacaoDto locar(LocacaoCampoDto dto) {
        LocacaoCampo locacao = LocacaoCampoMapper.paraDomainDeDto(dto);
        Optional<LocacaoCampo> locacaoOptional = locacaoCampoDataProvider.buscarPorHoraLocacao(locacao.getHoraLocacao(), locacao.getDataLocacao(), locacao.getCampo().getNumero());
        locacaoOptional.ifPresent(locacao1 -> {
            throw new RuntimeException(MENSAGEM_LOCACAO_JA_LOCADA);
        });

        Optional<Campo> campoOptional = campoDataProvider.buscarPorNumero(locacao.getCampo().getNumero());
        if(campoOptional.isPresent())
            locacao.setCampo(campoOptional.get());
        else
            throw new RuntimeException("Campo não encontrado");

        return LocacaoCampoMapper.paraDtoDeDomain(locacaoCampoDataProvider.salvar(locacao));
    }

    public List<LocacaoCampoDto> buscarPorTodos() {
        return LocacaoCampoMapper.paraDtosDeDomains(locacaoCampoDataProvider.getAll());
    }
}
