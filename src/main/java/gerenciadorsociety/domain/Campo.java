package gerenciadorsociety.domain;

import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.infrastructure.mappers.CampoMapper;
import gerenciadorsociety.infrastructure.mappers.EstabelecimentoMapper;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Campo {

    private Long id;
    private Integer numero;
    private Estabelecimento estabelecimento;

    public void setInformacoes(CampoDto campoDto) {
        if(campoDto.numero() != null)
            this.numero = campoDto.numero();
        if(campoDto.estabelecimento() != null)
            this.estabelecimento = EstabelecimentoMapper.paraDomainDeDto(campoDto.estabelecimento());
    }
}
