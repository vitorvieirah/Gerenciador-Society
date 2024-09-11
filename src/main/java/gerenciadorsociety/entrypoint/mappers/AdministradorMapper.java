package gerenciadorsociety.entrypoint.mappers;

import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;

import java.util.List;

public class AdministradorMapper implements Mapper<Administrador, AdministradorDto> {
    @Override
    public Administrador paraDomain(AdministradorDto dto) {
        return Administrador.builder()
                .id(dto.id())
                .cpf(dto.cpf())
                .nome(dto.nome())
                .email(dto.email())
                .numeroTelefone(dto.numeroTelefone())
                .build();
    }

    @Override
    public AdministradorDto paraDto(Administrador domain) {
        return AdministradorDto.builder()
                .id(domain.getId())
                .cpf(domain.getCpf())
                .nome(domain.getNome())
                .email(domain.getEmail())
                .numeroTelefone(domain.getNumeroTelefone())
                .build();
    }

    @Override
    public List<AdministradorDto> paraDtos(List<Administrador> domains) {
        return domains.stream().map(this::paraDto).toList();
    }
}
