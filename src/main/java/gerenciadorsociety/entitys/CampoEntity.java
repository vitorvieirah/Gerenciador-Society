package gerenciadorsociety.entitys;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
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
}
