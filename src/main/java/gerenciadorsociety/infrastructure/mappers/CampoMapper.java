package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.infrastructure.repositories.entities.CampoEntity;

import java.util.List;

public abstract class CampoMapper {

    public static Campo paraDomain(CampoEntity campoEntity) {
        return Campo.builder()
                .id(campoEntity.getId())
                .numero(campoEntity.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDomain(campoEntity.getEstabelecimento()))
                .build();
    }

    public static CampoEntity paraDomainDeDomain(Campo campo) {
        return CampoEntity.builder()
                .id(campo.getId())
                .numero(campo.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDomainDeDomain(campo.getEstabelecimento()))
                .build();
    }

    public static List<Campo> paraDomainsDeEntitys(List<CampoEntity> campoEntities) {
        return campoEntities.stream().map(CampoMapper::paraDomain).toList();
    }
}
