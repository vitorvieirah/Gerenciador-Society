package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import gerenciadorsociety.infrastructure.repositories.entities.ChurrasqueiraEntity;

public abstract class ChurrasqueiraMapper {

    public static Churrasqueira paraDomainDeEntity(ChurrasqueiraEntity churrasqueiraEntity) {
        return Churrasqueira.builder()
                .id(churrasqueiraEntity.getId())
                .numero(churrasqueiraEntity.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDomainDeEntity(churrasqueiraEntity.getEstabelecimento()))
                .build();
    }

    public static ChurrasqueiraEntity paraEntityDeDomain(Churrasqueira churrasqueira) {
        return ChurrasqueiraEntity.builder()
                .id(churrasqueira.getId())
                .numero(churrasqueira.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraEntityDeDomain(churrasqueira.getEstabelecimento()))
                .build();
    }
}
