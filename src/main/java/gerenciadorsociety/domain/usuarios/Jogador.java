package gerenciadorsociety.domain.usuarios;

import gerenciadorsociety.domain.Endereco;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Jogador {

    private Long id;
    private String nome;
    private String email;
    private String numeroTelefone;
    private String cpf;
    private Endereco endereco;
}
