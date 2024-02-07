package gerenciadorsociety.infra.mappers;

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
