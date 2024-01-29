package gerenciadorsociety.services;

import gerenciadorsociety.dtos.DonoDto;
import gerenciadorsociety.infra.dataprovider.DonoDataProvider;
import gerenciadorsociety.infra.mappers.DonoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DonoService {
    private final DonoDataProvider dataProvider;

    public DonoDto cadastrar(DonoDto dto) {
        return DonoMapper.paraDtoDeDomain(dataProvider.salvar(DonoMapper.paraDomainDeDto(dto)));
    }
}
