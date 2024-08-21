package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import gerenciadorsociety.infrastructure.repositories.entities.ChurrasqueiraEntity;

public abstract class ChurrasqueiraMapper {

    public static Churrasqueira paraDomain(ChurrasqueiraEntity churrasqueiraEntity) {
        return Churrasqueira.builder()
                .id(churrasqueiraEntity.getId())
                .numero(churrasqueiraEntity.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDomain(churrasqueiraEntity.getEstabelecimento()))
                .build();
    }

    public static ChurrasqueiraEntity paraDomainDeDomain(Churrasqueira churrasqueira) {
        return ChurrasqueiraEntity.builder()
                .id(churrasqueira.getId())
                .numero(churrasqueira.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDomainDeDomain(churrasqueira.getEstabelecimento()))
                .build();
    }
}
