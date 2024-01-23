package gerenciadorsociety.domains;

import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public abstract class Locacao {

    private Long id;
    private Estabelecimento estabelecimento;
    private Administrador administrador;
    private LocalDate dataLocacao;
    private Boolean ativo;

}
