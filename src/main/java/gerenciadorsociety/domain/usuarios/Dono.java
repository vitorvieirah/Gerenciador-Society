package gerenciadorsociety.domain.usuarios;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Dono {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String numeroTelefone;

    public void alterarInformacoes(Dono novosDados) {
        if (novosDados.getNome() != null)
            this.nome = novosDados.getNome();
        if (novosDados.getCpf() != null)
            this.cpf = novosDados.getCpf();
        if (novosDados.getEmail() != null)
            this.email = novosDados.getEmail();
        if (novosDados.getNumeroTelefone() != null)
            this.numeroTelefone = novosDados.getNumeroTelefone();
    }
}
