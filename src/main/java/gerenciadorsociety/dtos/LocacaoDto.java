package gerenciadorsociety.dtos;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public abstract class LocacaoDto {
    protected Long id;
    protected EstabelecimentoDto estabelecimento;
    protected AdministradorDto administrador;
    protected LocalDate dataLocacao;
    protected LocalDate data;
    protected LocalTime horaLocacao;
    protected Boolean ativo;
}
