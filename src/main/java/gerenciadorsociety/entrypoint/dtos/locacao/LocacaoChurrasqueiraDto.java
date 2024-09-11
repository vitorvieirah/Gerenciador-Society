package gerenciadorsociety.entrypoint.dtos.locacao;

import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@ToString
public class LocacaoChurrasqueiraDto extends LocacaoDto {

    private ChurrasqueiraDto churrasqueira;

    public LocacaoChurrasqueiraDto(Long id, EstabelecimentoDto estab, AdministradorDto adm, LocalDate dataLocacao, LocalDate data, LocalTime horaLocacao, Boolean ativo, ChurrasqueiraDto churrasqueira) {
        super(id, estab, adm, dataLocacao, data, horaLocacao, ativo);
        this.churrasqueira = churrasqueira;
    }
}
