package gerenciadorsociety.infra.entitys;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Entity(name = "Dono")
@Table(name = "donos")
public class DonoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private String numeroTelefone;
}
