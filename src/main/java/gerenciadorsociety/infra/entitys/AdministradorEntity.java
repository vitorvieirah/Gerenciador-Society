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
@Entity(name = "Administrador")
@Table(name = "admnistradores")
public class AdministradorEntity {
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String numeroTelefone;
}
