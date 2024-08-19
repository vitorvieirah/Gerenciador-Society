package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import gerenciadorsociety.infrastructure.repositories.entities.EstabelecimentoEntity;

import java.util.List;

public abstract class EstabelecimentoMapper {

    public static Estabelecimento paraDomainDeEntity(EstabelecimentoEntity estabEntity) {
        return Estabelecimento.builder()
                .id(estabEntity.getId())
                .cnpj(estabEntity.getCnpj())
                .nome(estabEntity.getNome())
                .dono(DonoMapper.paraDomainDeEntity(estabEntity.getDono()))
                .valorHora(estabEntity.getValorHora())
                .build();
    }

    public static EstabelecimentoEntity paraEntityDeDomain(Estabelecimento estabelecimento) {
        return EstabelecimentoEntity.builder()
                .id(estabelecimento.getId())
                .cnpj(estabelecimento.getCnpj())
                .nome(estabelecimento.getNome())
                .dono(DonoMapper.paraEntityDeDomain(estabelecimento.getDono()))
                .valorHora(estabelecimento.getValorHora())
                .build();
    }

    public static List<Estabelecimento> paraDomainsDeEntitys(List<EstabelecimentoEntity> estabEntityList) {
        return estabEntityList.stream().map(EstabelecimentoMapper::paraDomainDeEntity).toList();
    }

}
