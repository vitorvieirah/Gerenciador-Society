package gerenciadorsociety.domain.usuarios;

import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
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

    public void setInformacoes(AdministradorDto administradorDto) {
        if(administradorDto.nome() != null)
            this.nome = administradorDto.nome();
        if(administradorDto.email() != null)
            this.email = administradorDto.email();
        if(administradorDto.cpf() != null)
            this.cpf = administradorDto.cpf();
        if(administradorDto.numeroTelefone() != null)
            this.numeroTelefone = administradorDto.numeroTelefone();
    }
}
