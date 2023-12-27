package gerenciadorsociety.domains;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Administrador {
    private String nome;
    private String email;
    private String cpf;
    private String numeroTelefone;
}
