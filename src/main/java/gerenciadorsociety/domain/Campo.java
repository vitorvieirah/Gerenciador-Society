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

    public void setInformacoes(Campo novosDados) {
        if (novosDados.getNumero() != null)
            this.numero = novosDados.getNumero();
        if (novosDados.getEstabelecimento() != null)
            this.estabelecimento = novosDados.getEstabelecimento();
    }
}
