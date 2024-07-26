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

    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String cnpj;
    private Dono dono;
    private BigDecimal valorHora;
}
