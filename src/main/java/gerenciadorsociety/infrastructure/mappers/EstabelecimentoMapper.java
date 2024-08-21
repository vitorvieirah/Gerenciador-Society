package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import gerenciadorsociety.infrastructure.repositories.entities.EstabelecimentoEntity;

import java.util.List;

public abstract class EstabelecimentoMapper {

    public static Estabelecimento paraDomain(EstabelecimentoEntity estabEntity) {
        return Estabelecimento.builder()
                .id(estabEntity.getId())
                .cnpj(estabEntity.getCnpj())
                .nome(estabEntity.getNome())
                .dono(DonoMapper.paraDomain(estabEntity.getDono()))
                .valorHora(estabEntity.getValorHora())
                .build();
    }

    public static EstabelecimentoEntity paraDomainDeDomain(Estabelecimento estabelecimento) {
        return EstabelecimentoEntity.builder()
                .id(estabelecimento.getId())
                .cnpj(estabelecimento.getCnpj())
                .nome(estabelecimento.getNome())
                .dono(DonoMapper.paraDomainDeDomain(estabelecimento.getDono()))
                .valorHora(estabelecimento.getValorHora())
                .build();
    }

    public static List<Estabelecimento> paraDomainsDeEntitys(List<EstabelecimentoEntity> estabEntityList) {
        return estabEntityList.stream().map(EstabelecimentoMapper::paraDomain).toList();
    }

}
