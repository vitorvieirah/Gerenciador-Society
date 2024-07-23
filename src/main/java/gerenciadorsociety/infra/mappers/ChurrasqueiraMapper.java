package gerenciadorsociety.infra.mappers;

import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.dtos.ChurrasqueiraDto;
import gerenciadorsociety.infra.entitys.ChurrasqueiraEntity;

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

    public static Churrasqueira paraDomainDeDto(ChurrasqueiraDto churrasqueiraDto) {
        return Churrasqueira.builder()
                .id(churrasqueiraDto.id())
                .numero(churrasqueiraDto.numero())
                .estabelecimento(EstabelecimentoMapper.paraDomainDeDto(churrasqueiraDto.estabelecimento()))
                .build();
    }

    public static ChurrasqueiraDto paraDtoDeDomain(Churrasqueira churrasqueira) {
        return ChurrasqueiraDto.builder()
                .id(churrasqueira.getId())
                .numero(churrasqueira.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDtoDeDomain(churrasqueira.getEstabelecimento()))
                .build();
    }
}
