package gerenciadorsociety.domains;

import lombok.*;

import javax.xml.parsers.SAXParser;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Dono {
    private String nome;
    private String cpf;
    private String email;
    private String numeroTelefone;
}
