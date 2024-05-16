package gerenciadorsociety.domains;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
}
