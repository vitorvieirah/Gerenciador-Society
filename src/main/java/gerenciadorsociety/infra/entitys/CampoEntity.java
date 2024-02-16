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
@Entity(name = "Campo")
@Table(name = "campos")
public class CampoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Boolean reservado;
    @ManyToOne
    private EstabelecimentoEntity estabelecimento;
}
