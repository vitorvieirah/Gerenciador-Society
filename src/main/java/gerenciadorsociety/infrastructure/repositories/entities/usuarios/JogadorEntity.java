package gerenciadorsociety.infrastructure.repositories.entities.usuarios;

import gerenciadorsociety.domain.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Jogador")
@Table(name = "jogadores")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class JogadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String numeroTelefone;
    private String cpf;
    private Endereco endereco;
}
