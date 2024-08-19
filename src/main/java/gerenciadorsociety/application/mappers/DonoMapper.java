package gerenciadorsociety.application.mappers;

import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.entrypoint.dtos.usuarios.DonoDto;

import java.util.List;

public class DonoMapper implements Mapper<Dono, DonoDto>{
    @Override
    public Dono paraDomainDeDto(DonoDto dto) {
        return Dono.builder()
                .id(dto.id())
                .cpf(dto.cpf())
                .nome(dto.nome())
                .email(dto.email())
                .numeroTelefone(dto.numeroTelefone())
                .build();
    }

    @Override
    public DonoDto paraDtoDeDomain(Dono domain) {
        return DonoDto.builder()
                .id(domain.getId())
                .cpf(domain.getCpf())
                .nome(domain.getNome())
                .email(domain.getEmail())
                .numeroTelefone(domain.getNumeroTelefone())
                .build();
    }

    @Override
    public List<DonoDto> paraDtosDeDomains(List<Dono> domains) {
        return domains.stream().map(this::paraDtoDeDomain).toList();

    }
}
