package gerenciadorsociety.dtos;

import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public abstract class LocacaoDto {
    protected Long id;
    protected EstabelecimentoDto estabelecimento;
    protected AdministradorDto administrador;
    protected LocalDate dataLocacao;
    protected Boolean ativo;
}
