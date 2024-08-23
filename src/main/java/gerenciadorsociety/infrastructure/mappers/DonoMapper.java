package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.entrypoint.dtos.usuarios.DonoDto;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.DonoEntity;

import java.util.List;

public class DonoMapper implements Mapper<Dono, DonoEntity>{

    @Override
    public Dono paraDomain(DonoEntity donoEntity) {
        return Dono.builder()
                .id(donoEntity.getId())
                .cpf(donoEntity.getCpf())
                .nome(donoEntity.getNome())
                .email(donoEntity.getEmail())
                .numeroTelefone(donoEntity.getNumeroTelefone())
                .build();
    }

    @Override
    public DonoEntity paraEntity(Dono dono) {
        return DonoEntity.builder()
                .id(dono.getId())
                .cpf(dono.getCpf())
                .nome(dono.getNome())
                .email(dono.getEmail())
                .numeroTelefone(dono.getNumeroTelefone())
                .build();
    }

    @Override
    public List<Dono> paraDomains(List<DonoEntity> entities) {
        return entities.stream().map(this::paraDomain).toList();
    }
}
