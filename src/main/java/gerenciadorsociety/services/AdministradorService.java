package gerenciadorsociety.services;

import gerenciadorsociety.dtos.AdministradorDto;
import gerenciadorsociety.infra.dataprovider.AdministradorDataProvider;
import gerenciadorsociety.infra.mappers.AdministradorMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdministradorService {

    private final AdministradorDataProvider dataProvider;
    public AdministradorDto cadastrar(AdministradorDto dto) {
        return AdministradorMapper.paraDtoDeDomain(dataProvider.salvar(AdministradorMapper.paraDomainDeDto(dto)));
    }
}
