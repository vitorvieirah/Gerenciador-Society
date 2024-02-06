package gerenciadorsociety.services;

import gerenciadorsociety.domains.LocacaoChurrasqueira;
import gerenciadorsociety.dtos.LocacaoChurrasqueiraDto;
import gerenciadorsociety.dtos.LocacaoDto;
import gerenciadorsociety.infra.dataprovider.LocacaoChurrasqueiraDataProvider;
import gerenciadorsociety.infra.mappers.LocacaoChurrasqueiraMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocacaoChurrasqueiraService {

    private final LocacaoChurrasqueiraDataProvider dataProvider;

    public LocacaoDto locar(LocacaoChurrasqueiraDto dto) {
        LocacaoChurrasqueira locacao = LocacaoChurrasqueiraMapper.paraDomainDeDto(dto);
        Optional<LocacaoChurrasqueira> locacaoChurrasqueira = dataProvider.buscarLocacaoParaValidacao(locacao.getHoraLocacao(), locacao.getDataLocacao(), locacao.getChurrasqueira().getNumero());
        locacaoChurrasqueira.ifPresent(loc -> {
            throw new RuntimeException("Locacao ja existe");
        });
        return LocacaoChurrasqueiraMapper.paraDtoDeDomain(dataProvider.salvar(locacao));
    }

    public List<LocacaoChurrasqueiraDto> buscarPorTodos() {
        return LocacaoChurrasqueiraMapper.paraDtosDeDomains(dataProvider.getAll());
    }
}
