package gerenciadorsociety.domains;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public abstract class Locacao {

    protected Long id;
    protected Estabelecimento estabelecimento;
    protected Administrador administrador;
    protected LocalDate dataLocacao;
    protected LocalDate data;
    protected LocalTime horaLocacao;
    protected Boolean ativo;

}
