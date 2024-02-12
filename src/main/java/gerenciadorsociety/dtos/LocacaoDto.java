package gerenciadorsociety.dtos;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public abstract class LocacaoDto {
    private Long id;
    private EstabelecimentoDto estabelecimento;
    private AdministradorDto administrador;
    private LocalDate dataLocacao;
    private LocalDate data;
    private LocalTime horaLocacao;
    private Boolean ativo;
}
