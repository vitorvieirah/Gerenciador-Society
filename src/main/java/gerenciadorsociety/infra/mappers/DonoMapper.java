package gerenciadorsociety.infra.mappers;

import gerenciadorsociety.domains.Dono;
import gerenciadorsociety.dtos.DonoDto;
import gerenciadorsociety.infra.entitys.DonoEntity;

import java.util.List;

public abstract class DonoMapper {

    public static Dono paraDomainDeEntity(DonoEntity donoEntity){
        return Dono.builder()
                .cpf(donoEntity.getCpf())
                .nome(donoEntity.getNome())
                .email(donoEntity.getEmail())
                .numeroTelefone(donoEntity.getNumeroTelefone())
                .build();
    }

    public static DonoEntity paraEntityDeDomain(Dono dono){
        return DonoEntity.builder()
                .cpf(dono.getCpf())
                .nome(dono.getNome())
                .email(dono.getEmail())
                .numeroTelefone(dono.getNumeroTelefone())
                .build();
    }

    public static Dono paraDomainDeDto(DonoDto donoDto){
        return Dono.builder()
                .cpf(donoDto.cpf())
                .nome(donoDto.nome())
                .email(donoDto.email())
                .numeroTelefone(donoDto.numeroTelefone())
                .build();
    }

    public static DonoDto paraDtoDeDomain(Dono dono){
        return DonoDto.builder()
                .cpf(dono.getCpf())
                .nome(dono.getNome())
                .email(dono.getEmail())
                .numeroTelefone(dono.getNumeroTelefone())
                .build();
    }

    public static List<Dono> paraDomainsDeEntitys(List<DonoEntity> donoEntityList){
        return donoEntityList.stream().map(DonoMapper::paraDomainDeEntity).toList();
    }

    public static List<DonoDto> paraDtosDeDomains(List<Dono> donoList){
        return donoList.stream().map(DonoMapper::paraDtoDeDomain).toList();
    }
}
