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

    public void alterarInformacoes(Jogador novosDados) {
        if(novosDados.getNome() != null)
            this.nome = novosDados.getNome();
        if(novosDados.getEmail() != null)
            this.email = novosDados.getEmail();
        if(novosDados.getCpf() != null)
            this.cpf = novosDados.getCpf();
        if(novosDados.getNumeroTelefone() != null)
            this.numeroTelefone = novosDados.getNumeroTelefone();
        if(novosDados.getEndereco() != null)
            this.endereco = novosDados.getEndereco();
    }
}
