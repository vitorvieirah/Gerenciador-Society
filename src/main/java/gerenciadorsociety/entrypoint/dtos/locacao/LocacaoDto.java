package gerenciadorsociety.entrypoint.dtos.locacao;

import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
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
