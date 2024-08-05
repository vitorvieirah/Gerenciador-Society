package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.AdministradorEntity;

public abstract class AdministradorMapper {

    public static Administrador paraDomainDeEntiy(AdministradorEntity admEntity){
        return Administrador.builder()
                .id(admEntity.getId())
                .cpf(admEntity.getCpf())
                .nome(admEntity.getNome())
                .email(admEntity.getEmail())
                .numeroTelefone(admEntity.getNumeroTelefone())
                .build();
    }

    public static AdministradorEntity paraEntityDeDomain(Administrador adm){
        return AdministradorEntity.builder()
                .id(adm.getId())
                .cpf(adm.getCpf())
                .nome(adm.getNome())
                .email(adm.getEmail())
                .numeroTelefone(adm.getNumeroTelefone())
                .build();
    }

    public static Administrador paraDomainDeDto(AdministradorDto admDto){
        return Administrador.builder()
                .id(admDto.id())
                .cpf(admDto.cpf())
                .nome(admDto.nome())
                .email(admDto.email())
                .numeroTelefone(admDto.numeroTelefone())
                .build();
    }

    public static AdministradorDto paraDtoDeDomain(Administrador adm){
        return AdministradorDto.builder()
                .id(adm.getId())
                .cpf(adm.getCpf())
                .nome(adm.getNome())
                .email(adm.getEmail())
                .numeroTelefone(adm.getNumeroTelefone())
                .build();
    }
}
