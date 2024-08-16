package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.infrastructure.repositories.entities.CampoEntity;

import java.util.List;

public abstract class CampoMapper {

    public static Campo paraDomainDeEntity(CampoEntity campoEntity) {
        return Campo.builder()
                .id(campoEntity.getId())
                .numero(campoEntity.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDomainDeEntity(campoEntity.getEstabelecimento()))
                .build();
    }

    public static CampoEntity paraEntityDeDomain(Campo campo) {
        return CampoEntity.builder()
                .id(campo.getId())
                .numero(campo.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraEntityDeDomain(campo.getEstabelecimento()))
                .build();
    }

    public static List<Campo> paraDomainsDeEntitys(List<CampoEntity> campoEntities) {
        return campoEntities.stream().map(CampoMapper::paraDomainDeEntity).toList();
    }
}
