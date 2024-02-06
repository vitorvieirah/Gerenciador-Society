package gerenciadorsociety.services;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.dtos.CampoDto;
import gerenciadorsociety.infra.dataprovider.CampoDataProvider;
import gerenciadorsociety.infra.mappers.CampoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CampoService {

    private final CampoDataProvider dataProvider;

    public CampoDto cadastrar(CampoDto dto) {
        Optional<Campo> campo = dataProvider.buscarPorNumero(dto.numero());
        campo.ifPresent(cmp -> {
            throw new RuntimeException("Campo ja esta cadastrado");
        });
        return CampoMapper.paraDtoDeDomain(dataProvider.salvar(CampoMapper.paraDomainDeDto(dto)));
    }
}
