package gerenciadorsociety.services;

import gerenciadorsociety.dtos.ChurrasqueiraDto;
import gerenciadorsociety.infra.dataprovider.ChurrasqueiraDataProvider;
import gerenciadorsociety.infra.mappers.ChurrasqueiraMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChurrasqueiraService {

    private final ChurrasqueiraDataProvider dataProvider;

    public ChurrasqueiraDto cadastrar(ChurrasqueiraDto dto) {
        return ChurrasqueiraMapper.paraDtoDeDomain(dataProvider.salvar(ChurrasqueiraMapper.paraDomainDeDto(dto)));
    }
}
