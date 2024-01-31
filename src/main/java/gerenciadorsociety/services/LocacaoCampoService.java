package gerenciadorsociety.services;

import gerenciadorsociety.domains.Administrador;
import gerenciadorsociety.domains.Locacao;
import gerenciadorsociety.domains.LocacaoCampo;
import gerenciadorsociety.dtos.LocacaoCampoDto;
import gerenciadorsociety.dtos.LocacaoDto;
import gerenciadorsociety.infra.dataprovider.LocacaoCampoDataProvider;
import gerenciadorsociety.infra.dataprovider.LocacaoChurrasqueiraDataProvider;
import gerenciadorsociety.infra.mappers.LocacaoCampoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LocacaoCampoService {

    private final LocacaoCampoDataProvider locacaoCampoDataProvider;

    private static final String MENSAGEM_LOCACAO_JA_LOCADA = "Locação já existe";

    public LocacaoDto locar(LocacaoCampoDto dto) {
         //LocacaoCampoMapper.paraDtoDeDomain(locacaoCampoDataProvider.salvar(LocacaoCampoMapper.paraDomainDeDto(dto)));
        Locacao locacao = LocacaoCampoMapper.paraDomainDeDto(dto);
        Optional<Locacao> locacaoOptional = locacaoCampoDataProvider.buscarPorId(locacao.getId());
        locacaoOptional.ifPresent(locacaoExiste -> {

        });
    }
}
