package gerenciadorsociety.services;

import gerenciadorsociety.domains.Estabelecimento;
import gerenciadorsociety.dtos.EstabelecimentoDto;
import gerenciadorsociety.infra.dataprovider.EstabelecimentoDataProvider;
import gerenciadorsociety.infra.mappers.EstabelecimentoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoDataProvider dataProvider;

    public EstabelecimentoDto cadastrar(EstabelecimentoDto dto) {
        Optional<Estabelecimento> estabelecimento = dataProvider.consultarPorCnpj(dto.cnpj());
        estabelecimento.ifPresent(estb -> {
            throw new RuntimeException("Estabelecimento ja cadastrado");
        });

        return EstabelecimentoMapper.paraDtoDeDomain(dataProvider.salvar(EstabelecimentoMapper.paraDomainDeDto(dto)));
    }

    public List<EstabelecimentoDto> getEstabelecimentos() {
        return EstabelecimentoMapper.paraDtosDeDomains(dataProvider.consultarTodos());
    }

    public void deletar (String cnpj){
        dataProvider.deletar(cnpj);
    }
}
