package gerenciadorsociety.services;

import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.dtos.ChurrasqueiraDto;
import gerenciadorsociety.infra.dataprovider.ChurrasqueiraDataProvider;
import gerenciadorsociety.infra.mappers.ChurrasqueiraMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ChurrasqueiraService {

    private final ChurrasqueiraDataProvider dataProvider;

    public ChurrasqueiraDto cadastrar(ChurrasqueiraDto dto) {
        Optional<Churrasqueira> churrasqueira = dataProvider.buscarPorNumero(dto.numero());
        churrasqueira.ifPresent(chr -> {
            throw new RuntimeException("Churrasqueira ja cadastrada");
        });
        return ChurrasqueiraMapper.paraDtoDeDomain(dataProvider.salvar(ChurrasqueiraMapper.paraDomainDeDto(dto)));
    }
}
