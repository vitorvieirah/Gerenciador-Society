package gerenciadorsociety.domains;

import lombok.*;

import java.time.LocalDate;



@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public abstract class Locacao {

    protected Long id;
    protected Estabelecimento estabelecimento;
    protected Administrador administrador;
    protected LocalDate dataLocacao;
    protected Boolean ativo;

}
