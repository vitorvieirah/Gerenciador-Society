package gerenciadorsociety.domains;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Setter
public class Estabelecimento {
    private String nome;
    private String cnpj;
    private Dono dono;
    private List<Campo> campos;
    private List<Churrasqueira> churrasqueiras;
    private BigDecimal valorHora;
}
