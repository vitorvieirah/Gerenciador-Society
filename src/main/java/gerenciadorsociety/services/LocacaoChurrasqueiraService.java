package gerenciadorsociety.services;

import gerenciadorsociety.dtos.LocacaoChurrasqueiraDto;
import gerenciadorsociety.dtos.LocacaoDto;
import gerenciadorsociety.infra.dataprovider.LocacaoChurrasqueiraDataProvider;
import gerenciadorsociety.infra.mappers.LocacaoChurrasqueiraMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocacaoChurrasqueiraService {

    private final LocacaoChurrasqueiraDataProvider dataProvider;

    public LocacaoDto locar(LocacaoChurrasqueiraDto dto) {
        return LocacaoChurrasqueiraMapper.paraDtoDeDomain(dataProvider.salvar(LocacaoChurrasqueiraMapper.paraDomainDeDto(dto)));
    }
}
