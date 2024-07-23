package gerenciadorsociety.infra.entitys;

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
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "numero_churrasqueira")
    private Integer numero;
    @ManyToOne
    private EstabelecimentoEntity estabelecimento;
}
