package gerenciadorsociety.infrastructure.repositories.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@Entity(name = "Estabelecimento")
@Table(name = "estabelecimentos")
public class EstabelecimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String cnpj;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "id_dono", nullable = false)
    private DonoEntity dono;
    private BigDecimal valorHora;
}
