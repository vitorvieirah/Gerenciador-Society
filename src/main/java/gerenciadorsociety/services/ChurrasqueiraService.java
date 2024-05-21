package gerenciadorsociety.services;

import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.domains.Estabelecimento;
import gerenciadorsociety.dtos.ChurrasqueiraDto;
import gerenciadorsociety.infra.dataprovider.ChurrasqueiraDataProvider;
import gerenciadorsociety.infra.dataprovider.EstabelecimentoDataProvider;
import gerenciadorsociety.infra.mappers.ChurrasqueiraMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ChurrasqueiraService {

    private final ChurrasqueiraDataProvider dataProvider;
    private final EstabelecimentoDataProvider estabelecimentoDataProvider;

    public ChurrasqueiraDto cadastrar(ChurrasqueiraDto dto) {
        Optional<Churrasqueira> churrasqueiraOptional = dataProvider.buscarPorNumero(dto.numero());
        churrasqueiraOptional.ifPresent(chr -> {
            throw new RuntimeException("Churrasqueira ja cadastrada");
        });
        Churrasqueira churrasqueira = ChurrasqueiraMapper.paraDomainDeDto(dto);
        Optional<Estabelecimento> estabelecimento = estabelecimentoDataProvider.consultarPorCnpj(dto.estabelecimento().cnpj());

        if(estabelecimento.isEmpty())
            throw new RuntimeException("Estabelecimento não encontrado");

        churrasqueira.setEstabelecimento(estabelecimento.get());

        return ChurrasqueiraMapper.paraDtoDeDomain(dataProvider.salvar(churrasqueira));
    }
}
