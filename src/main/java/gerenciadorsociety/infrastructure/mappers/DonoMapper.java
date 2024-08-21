package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.entrypoint.dtos.usuarios.DonoDto;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.DonoEntity;

public abstract class DonoMapper {

    public static Dono paraDomain(DonoEntity donoEntity) {
        return Dono.builder()
                .id(donoEntity.getId())
                .cpf(donoEntity.getCpf())
                .nome(donoEntity.getNome())
                .email(donoEntity.getEmail())
                .numeroTelefone(donoEntity.getNumeroTelefone())
                .build();
    }

    public static DonoEntity paraDomainDeDomain(Dono dono) {
        return DonoEntity.builder()
                .id(dono.getId())
                .cpf(dono.getCpf())
                .nome(dono.getNome())
                .email(dono.getEmail())
                .numeroTelefone(dono.getNumeroTelefone())
                .build();
    }
}
