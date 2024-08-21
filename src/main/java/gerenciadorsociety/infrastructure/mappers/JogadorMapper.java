package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.usuarios.Jogador;
import gerenciadorsociety.entrypoint.dtos.usuarios.JogadorDto;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.JogadorEntity;

public abstract class JogadorMapper {

    public static JogadorEntity paraDomain(Jogador jogador) {
        return JogadorEntity.builder()
                .id(jogador.getId())
                .nome(jogador.getNome())
                .email(jogador.getEmail())
                .numeroTelefone(jogador.getNumeroTelefone())
                .cpf(jogador.getCpf())
                .endereco(jogador.getEndereco())
                .build();
    }

    public static Jogador paraDomain(JogadorEntity jogadorEntity) {
        return Jogador.builder()
                .id(jogadorEntity.getId())
                .nome(jogadorEntity.getNome())
                .email(jogadorEntity.getEmail())
                .numeroTelefone(jogadorEntity.getNumeroTelefone())
                .cpf(jogadorEntity.getCpf())
                .endereco(jogadorEntity.getEndereco())
                .build();
    }
}
