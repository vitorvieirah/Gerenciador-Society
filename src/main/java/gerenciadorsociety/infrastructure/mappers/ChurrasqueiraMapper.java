package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import gerenciadorsociety.infrastructure.repositories.entities.ChurrasqueiraEntity;
import gerenciadorsociety.infrastructure.repositories.entities.EstabelecimentoEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ChurrasqueiraMapper implements Mapper<Churrasqueira, ChurrasqueiraEntity>{

    private final Mapper<Estabelecimento, EstabelecimentoEntity> estabelecimentoMapper;

    @Override
    public Churrasqueira paraDomain(ChurrasqueiraEntity churrasqueiraEntity) {
        return Churrasqueira.builder()
                .id(churrasqueiraEntity.getId())
                .numero(churrasqueiraEntity.getNumero())
                .estabelecimento(estabelecimentoMapper.paraDomain(churrasqueiraEntity.getEstabelecimento()))
                .build();
    }

    @Override
    public ChurrasqueiraEntity paraEntity(Churrasqueira churrasqueira) {
        return ChurrasqueiraEntity.builder()
                .id(churrasqueira.getId())
                .numero(churrasqueira.getNumero())
                .estabelecimento(estabelecimentoMapper.paraEntity(churrasqueira.getEstabelecimento()))
                .build();
    }

    @Override
    public List<Churrasqueira> paraDomains(List<ChurrasqueiraEntity> entities) {
        return entities.stream().map(this::paraDomain).toList();
    }
}
