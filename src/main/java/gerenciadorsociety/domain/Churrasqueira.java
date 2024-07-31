package gerenciadorsociety.domain;

import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import lombok.*;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
@Builder
public class Churrasqueira {

    @EqualsAndHashCode.Include
    private Long id;
    private Integer numero;
    private Estabelecimento estabelecimento;

    public void atualizarInformacoes(ChurrasqueiraDto dto) {
        if(dto.numero() != null)
            this.numero = dto.numero();
    }
}
