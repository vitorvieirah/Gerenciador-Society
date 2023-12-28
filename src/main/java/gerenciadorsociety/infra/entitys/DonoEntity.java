package gerenciadorsociety.infra.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Entity(name = "Dono")
@Table(name = "donos")
public class DonoEntity {
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String numeroTelefone;
}
