package gerenciadorsociety.domain.usuarios;

import gerenciadorsociety.entrypoint.dtos.usuarios.DonoDto;
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

    public void alterarInformacoes(DonoDto novosDados) {
        if (novosDados.nome() != null)
            this.nome = novosDados.nome();
        if (novosDados.cpf() != null)
            this.cpf = novosDados.cpf();
        if (novosDados.email() != null)
            this.email = novosDados.email();
        if (novosDados.numeroTelefone() != null)
            this.numeroTelefone = novosDados.numeroTelefone();
    }
}
