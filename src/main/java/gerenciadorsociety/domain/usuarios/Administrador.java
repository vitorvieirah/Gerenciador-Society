package gerenciadorsociety.domain.usuarios;

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

    public void setInformacoes(Administrador novosDados) {
        if(novosDados.getNome() != null)
            this.nome = novosDados.getNome();
        if(novosDados.getEmail() != null)
            this.email = novosDados.getEmail();
        if(novosDados.getCpf() != null)
            this.cpf = novosDados.getCpf();
        if(novosDados.getNumeroTelefone() != null)
            this.numeroTelefone = novosDados.getNumeroTelefone();
    }
}
