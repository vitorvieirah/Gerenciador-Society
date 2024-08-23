package gerenciadorsociety.application.mappers;

import gerenciadorsociety.domain.usuarios.Jogador;
import gerenciadorsociety.entrypoint.dtos.usuarios.JogadorDto;

import java.util.List;

public class JogadorMapper implements Mapper<Jogador, JogadorDto>{
    @Override
    public Jogador paraDomain(JogadorDto dto) {
        return Jogador.builder()
                .id(dto.id())
                .nome(dto.nome())
                .email(dto.email())
                .numeroTelefone(dto.numeroTelefone())
                .cpf(dto.cpf())
                .endereco(dto.endereco())
                .build();
    }

    @Override
    public JogadorDto paraDto(Jogador domain) {
        return JogadorDto.builder()
                .id(domain.getId())
                .nome(domain.getNome())
                .email(domain.getEmail())
                .numeroTelefone(domain.getNumeroTelefone())
                .cpf(domain.getCpf())
                .endereco(domain.getEndereco())
                .build();
    }

    @Override
    public List<JogadorDto> paraDtos(List<Jogador> domains) {
        return domains.stream().map(this::paraDto).toList();
    }
}
