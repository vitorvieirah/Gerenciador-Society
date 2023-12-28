package gerenciadorsociety.infra.entitys;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.domains.Dono;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Entity(name = "Estabelecimento")
@Table(name = "estabelecimentos")
public class EstabelecimentoEntity {
    @Id
    private String cnpj;
    private String nome;
    private DonoEntity dono;
    @ManyToOne
    @JoinColumn(name = "numero_campo", nullable = false)
    private List<CampoEntity> campos;
    @ManyToOne
    @JoinColumn(name = "numero_churrasqueira", nullable = false)
    private List<ChurrasqueiraEntity> churrasqueiras;
    private BigDecimal valorHora;
}
