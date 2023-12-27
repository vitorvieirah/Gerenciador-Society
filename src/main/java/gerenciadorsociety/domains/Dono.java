package gerenciadorsociety.domains;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.xml.parsers.SAXParser;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Dono {
    private String nome;
    private String cpf;
    private String email;
    private String numeroTelefone;
}
