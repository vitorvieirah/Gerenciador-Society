package gerenciadorsociety.infra.entitys;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
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
    private Integer numero;
    private Boolean reservada;
}
