package gerenciadorsociety.domain;

import lombok.*;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
@Builder
public class Churrasqueira {

    private Long id;
    private Integer numero;
    private Estabelecimento estabelecimento;

    public void atualizarInformacoes(Churrasqueira novosDados) {
        if (novosDados.getNumero() != null)
            this.numero = novosDados.getNumero();
    }
}
