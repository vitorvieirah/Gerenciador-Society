package gerenciadorsociety.domain.locacao;

import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.domain.usuarios.Administrador;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Setter
@Getter
public abstract class Locacao {

    @EqualsAndHashCode.Include
    private Long id;
    private Estabelecimento estabelecimento;
    private Administrador administrador;
    private LocalDate dataLocacao;
    private LocalDate data;
    private LocalTime horaLocacao;
    private Boolean ativo;
}
