package gerenciadorsociety.services;

import gerenciadorsociety.dtos.EstabelecimentoDto;
import gerenciadorsociety.infra.dataprovider.EstabelecimentoDataProvider;
import gerenciadorsociety.infra.mappers.EstabelecimentoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoDataProvider dataProvider;

    public EstabelecimentoDto cadastrar(EstabelecimentoDto dto) {
        return EstabelecimentoMapper.paraDtoDeDomain(dataProvider.salvar(EstabelecimentoMapper.paraDomainDeDto(dto)));
    }

    public List<EstabelecimentoDto> getEstabelecimentos() {
        return EstabelecimentoMapper.paraDtosDeDomains(dataProvider.consultarTodos());
    }
}
