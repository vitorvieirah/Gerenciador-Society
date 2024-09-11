package gerenciadorsociety.domain;

import gerenciadorsociety.domain.usuarios.Dono;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Setter
public class Estabelecimento {

    private Long id;
    private String nome;
    private String cnpj;
    private Dono dono;
    private BigDecimal valorHora;

    public void alterarInformacoes(Estabelecimento novosDados) {
        if (novosDados.getNome() != null)
            this.nome = novosDados.getNome();
        if (novosDados.getCnpj() != null)
            this.cnpj = novosDados.getCnpj();
        if (novosDados.getDono() != null)
            this.dono = novosDados.getDono();
        if (novosDados.getValorHora() != null)
            this.valorHora = novosDados.getValorHora();
    }
}
