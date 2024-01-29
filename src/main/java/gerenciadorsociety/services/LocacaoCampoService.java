package gerenciadorsociety.services;

import gerenciadorsociety.domains.LocacaoCampo;
import gerenciadorsociety.dtos.LocacaoCampoDto;
import gerenciadorsociety.dtos.LocacaoDto;
import gerenciadorsociety.infra.dataprovider.LocacaoCampoDataProvider;
import gerenciadorsociety.infra.dataprovider.LocacaoChurrasqueiraDataProvider;
import gerenciadorsociety.infra.mappers.LocacaoCampoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocacaoCampoService {

    private final LocacaoCampoDataProvider locacaoCampoDataProvider;

    public LocacaoDto locar(LocacaoCampoDto dto) {
        return LocacaoCampoMapper.paraDtoDeDomain(locacaoCampoDataProvider.salvar(LocacaoCampoMapper.paraDomainDeDto(dto)));
    }
}
