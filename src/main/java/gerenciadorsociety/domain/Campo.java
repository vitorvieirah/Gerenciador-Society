package gerenciadorsociety.domain;

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

    public void setInformacoes(Campo campoDto) {
        if(campoDto.getNumero() != null)
            this.numero = campoDto.getNumero();
        if(campoDto.getEstabelecimento() != null)
            this.estabelecimento = campoDto.getEstabelecimento();
    }
}
