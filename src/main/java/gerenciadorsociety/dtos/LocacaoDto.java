package gerenciadorsociety.dtos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public abstract class LocacaoDto {
    private Long id;
    private EstabelecimentoDto estabelecimento;
    private AdministradorDto administrador;
    private LocalDate dataLocacao;
    private Boolean ativo;
}
