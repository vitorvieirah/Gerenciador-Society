package gerenciadorsociety.infra.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@Entity(name = "Estabelecimento")
@Table(name = "estabelecimentos")
public class EstabelecimentoEntity {

    @Id
    private String cnpj;
    private String nome;
    @OneToOne
    private DonoEntity dono;
    @OneToMany
    private List<CampoEntity> campos;
    @OneToMany
    private List<ChurrasqueiraEntity> churrasqueiras;
    private BigDecimal valorHora;
}
