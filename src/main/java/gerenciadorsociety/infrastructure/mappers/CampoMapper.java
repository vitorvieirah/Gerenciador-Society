package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.infrastructure.repositories.entities.CampoEntity;

import java.util.List;

public class CampoMapper implements Mapper<Campo, CampoEntity>{

    @Override
    public Campo paraDomain(CampoEntity campoEntity) {
        return Campo.builder()
                .id(campoEntity.getId())
                .numero(campoEntity.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDomain(campoEntity.getEstabelecimento()))
                .build();
    }

    @Override
    public CampoEntity paraEntity(Campo campo) {
        return CampoEntity.builder()
                .id(campo.getId())
                .numero(campo.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDomainDeDomain(campo.getEstabelecimento()))
                .build();
    }

    @Override
    public List<Campo> paraDomains(List<CampoEntity> campoEntities) {
        return campoEntities.stream().map(this::paraDomain).toList();
    }
}
