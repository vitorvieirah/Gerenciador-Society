package gerenciadorsociety.infra.mappers;

import gerenciadorsociety.domains.Jogador;
import gerenciadorsociety.dtos.JogadorDto;

public abstract class JogadorMapper {

    public static Jogador paraDomainDeDto(JogadorDto jogadorDto){
        return Jogador.builder()
                .nome(jogadorDto.nome())
                .build();
    }

    public static JogadorDto paraDtoDeDomain(Jogador jogador){
        return JogadorDto.builder()
                .nome(jogador.getNome())
                .build();
    }
}
