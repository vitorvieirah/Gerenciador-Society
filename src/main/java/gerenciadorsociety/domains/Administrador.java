package gerenciadorsociety.domains;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Administrador {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String numeroTelefone;
}
