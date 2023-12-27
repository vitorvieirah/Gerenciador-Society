package gerenciadorsociety.domains;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Estabelecimento {
    private String nome;
    private String cnpj;
    private Dono dono;
    private List<Campo> campos;
    private List<Churrasqueira> churrasqueiras;
    private BigDecimal valorHora;
}
