package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.infrastructure.repositories.entities.CampoEntity;

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

    public static CampoDto paraDtoDeDomain(Campo campo) {
        return CampoDto.builder()
                .id(campo.getId())
                .numero(campo.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDtoDeDomain(campo.getEstabelecimento()))
                .build();
    }

    public static Campo paraDomainDeDto(CampoDto campoDto) {
        return Campo.builder()
                .id(campoDto.id())
                .numero(campoDto.numero())
                .estabelecimento(EstabelecimentoMapper.paraDomainDeDto(campoDto.estabelecimento()))
                .build();
    }
}