package gerenciadorsociety.dtos;

import gerenciadorsociety.domains.LocacaoChurrasqueira;
import gerenciadorsociety.infra.entitys.AdministradorEntity;
import gerenciadorsociety.infra.entitys.CampoEntity;
import gerenciadorsociety.infra.entitys.EstabelecimentoEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@ToString
public class LocacaoChurrasqueiraDto extends LocacaoDto{
    private ChurrasqueiraDto churrasqueira;

    public LocacaoChurrasqueiraDto(Long id, EstabelecimentoDto estab, AdministradorDto adm, LocalDate dataLocacao, LocalDate data, LocalTime horaLocacao, Boolean ativo, ChurrasqueiraDto churrasqueira){
        super(id, estab, adm, dataLocacao, data, horaLocacao, ativo);
        this.churrasqueira = churrasqueira;
    }
}