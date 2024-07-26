package gerenciadorsociety.domain.usuarios;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Dono {

    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String numeroTelefone;
}
