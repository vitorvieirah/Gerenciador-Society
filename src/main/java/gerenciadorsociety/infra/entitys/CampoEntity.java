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
    @Column(name = "numero_campo")
    private Integer numero;
    private Boolean reservado;
    @ManyToOne
    @JoinColumn(name = "cnpj_estabelecimento")
    private EstabelecimentoEntity estabelecimento;
}
