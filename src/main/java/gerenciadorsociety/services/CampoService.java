package gerenciadorsociety.services;

import gerenciadorsociety.dtos.CampoDto;
import gerenciadorsociety.infra.dataprovider.CampoDataProvider;
import gerenciadorsociety.infra.mappers.CampoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CampoService {

    private final CampoDataProvider dataProvider;

    public CampoDto cadastrar(CampoDto dto) {
        return CampoMapper.paraDtoDeDomain(dataProvider.salvar(CampoMapper.paraDomainDeDto(dto)));
    }
}
