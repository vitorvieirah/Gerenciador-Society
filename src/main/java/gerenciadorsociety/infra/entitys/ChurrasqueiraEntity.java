package gerenciadorsociety.infra.entitys;

import gerenciadorsociety.domains.Estabelecimento;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Entity(name = "Churrasqueira")
@Table(name = "churrasqueiras")
public class ChurrasqueiraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_churrasqueira")
    private Integer numero;
    private Boolean reservada;
    @ManyToOne
    @JoinColumn(name = "cnpj_estabelecimento")
    private EstabelecimentoEntity estabelecimento;
}
