package gerenciadorsociety.infra.mappers;

import gerenciadorsociety.domains.Administrador;
import gerenciadorsociety.dtos.AdministradorDto;
import gerenciadorsociety.infra.entitys.AdministradorEntity;

import java.util.List;

public abstract class AdministradorMapper {

    public static Administrador paraDomainDeEntiy(AdministradorEntity admEntity){
        return Administrador.builder()
                .cpf(admEntity.getCpf())
                .nome(admEntity.getNome())
                .email(admEntity.getEmail())
                .numeroTelefone(admEntity.getNumeroTelefone())
                .build();
    }

    public static AdministradorEntity paraEntityDeDomain(Administrador adm){
        return AdministradorEntity.builder()
                .cpf(adm.getCpf())
                .nome(adm.getNome())
                .email(adm.getEmail())
                .numeroTelefone(adm.getNumeroTelefone())
                .build();
    }

    public static Administrador paraDomainDeDto(AdministradorDto admDto){
        return Administrador.builder()
                .cpf(admDto.cpf())
                .nome(admDto.nome())
                .email(admDto.email())
                .numeroTelefone(admDto.numeroTelefone())
                .build();
    }

    public static AdministradorDto paraDtoDeDomain(Administrador adm){
        return AdministradorDto.builder()
                .cpf(adm.getCpf())
                .nome(adm.getNome())
                .email(adm.getEmail())
                .numeroTelefone(adm.getNumeroTelefone())
                .build();
    }

    public static List<Administrador> paraDomainsDeEntitys(List<AdministradorEntity> admEntityList){
        return admEntityList.stream().map(AdministradorMapper::paraDomainDeEntiy).toList();
    }

    public static List<AdministradorDto> paraDtosDeDomains(List<Administrador> admList){
        return admList.stream().map(AdministradorMapper::paraDtoDeDomain).toList();
    }

    public static List<Administrador> paraDomainsDeDtos(List<AdministradorDto> admDtoList){
        return admDtoList.stream().map(AdministradorMapper::paraDomainDeDto).toList();
    }
}
