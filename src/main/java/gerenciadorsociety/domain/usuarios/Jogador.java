package gerenciadorsociety.domain.usuarios;

import gerenciadorsociety.domain.Endereco;
import gerenciadorsociety.entrypoint.dtos.usuarios.JogadorDto;
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

    public void alterarInformacoes(JogadorDto novosDados) {
        if(novosDados.nome() != null)
            this.nome = novosDados.nome();
        if(novosDados.email() != null)
            this.email = novosDados.email();
        if(novosDados.cpf() != null)
            this.cpf = novosDados.cpf();
        if(novosDados.numeroTelefone() != null)
            this.numeroTelefone = novosDados.numeroTelefone();
        if(novosDados.endereco() != null)
            this.endereco = novosDados.endereco();
    }
}
