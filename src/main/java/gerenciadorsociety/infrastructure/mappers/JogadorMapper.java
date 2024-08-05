package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.usuarios.Jogador;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.JogadorEntity;

public abstract class JogadorMapper {

    public static JogadorEntity paraEntity(Jogador jogador){
        return JogadorEntity.builder()
                .id(jogador.getId())
                .nome(jogador.getNome())
                .email(jogador.getEmail())
                .numeroTelefone(jogador.getNumeroTelefone())
                .cpf(jogador.getCpf())
                .endereco(jogador.getEndereco())
                .build();
    }
}
