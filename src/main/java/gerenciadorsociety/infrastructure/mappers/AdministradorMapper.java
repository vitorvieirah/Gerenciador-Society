package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.AdministradorEntity;

public abstract class AdministradorMapper {

    public static Administrador paraDomain(AdministradorEntity admEntity){
        return Administrador.builder()
                .id(admEntity.getId())
                .cpf(admEntity.getCpf())
                .nome(admEntity.getNome())
                .email(admEntity.getEmail())
                .numeroTelefone(admEntity.getNumeroTelefone())
                .build();
    }

    public static AdministradorEntity paraEntity(Administrador adm){
        return AdministradorEntity.builder()
                .id(adm.getId())
                .cpf(adm.getCpf())
                .nome(adm.getNome())
                .email(adm.getEmail())
                .numeroTelefone(adm.getNumeroTelefone())
                .build();
    }
}
