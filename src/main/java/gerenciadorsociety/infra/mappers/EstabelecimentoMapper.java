package gerenciadorsociety.infra.mappers;

import gerenciadorsociety.domains.Estabelecimento;
import gerenciadorsociety.dtos.EstabelecimentoDto;
import gerenciadorsociety.infra.entitys.EstabelecimentoEntity;

import java.util.List;

public abstract class EstabelecimentoMapper {

    public static Estabelecimento paraDomainDeEntity(EstabelecimentoEntity estabEntity){
        return Estabelecimento.builder()
                .cnpj(estabEntity.getCnpj())
                .nome(estabEntity.getNome())
                .dono(DonoMapper.paraDomainDeEntity(estabEntity.getDono()))
                .valorHora(estabEntity.getValorHora())
                .build();
    }

    public static EstabelecimentoEntity paraEntityDeDomain(Estabelecimento estabelecimento){
        return EstabelecimentoEntity.builder()
                .cnpj(estabelecimento.getCnpj())
                .nome(estabelecimento.getNome())
                .dono(DonoMapper.paraEntityDeDomain(estabelecimento.getDono()))
                .valorHora(estabelecimento.getValorHora())
                .build();
    }

    public static Estabelecimento paraDomainDeDto(EstabelecimentoDto estabelecimentoDto){
        return Estabelecimento.builder()
                .cnpj(estabelecimentoDto.cnpj())
                .nome(estabelecimentoDto.nome())
                .valorHora(estabelecimentoDto.valorHora())
                .build();
    }

    public static EstabelecimentoDto paraDtoDeDomain(Estabelecimento estabelecimento){
        return EstabelecimentoDto.builder()
                .cnpj(estabelecimento.getCnpj())
                .nome(estabelecimento.getNome())
                .dono(DonoMapper.paraDtoDeDomain(estabelecimento.getDono()))
                .valorHora(estabelecimento.getValorHora())
                .build();
    }

    public static List<Estabelecimento> paraDomainsDeEntitys(List<EstabelecimentoEntity> estabEntityList){
        return estabEntityList.stream().map(EstabelecimentoMapper::paraDomainDeEntity).toList();
    }

    public static List<EstabelecimentoDto> paraDtosDeDomains(List<Estabelecimento> estabelecimentoList){
        return estabelecimentoList.stream().map(EstabelecimentoMapper::paraDtoDeDomain).toList();
    }
}
