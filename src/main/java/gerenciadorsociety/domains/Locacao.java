package gerenciadorsociety.domains;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public abstract class Locacao {

    private Long id;
    private Estabelecimento estabelecimento;
    private Administrador administrador;
    private LocalDate dataLocacao;
    private LocalDate data;
    private LocalTime horaLocacao;
    private Boolean ativo;

}
