package gerenciadorsociety.domain.usuarios;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Administrador {

    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String numeroTelefone;
}