package gerenciadorsociety.dtos;

import gerenciadorsociety.domains.LocacaoChurrasqueira;
import gerenciadorsociety.infra.entitys.AdministradorEntity;
import gerenciadorsociety.infra.entitys.CampoEntity;
import gerenciadorsociety.infra.entitys.EstabelecimentoEntity;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@ToString
public class LocacaoChurrasqueiraDto extends LocacaoDto{
    private ChurrasqueiraDto churrasqueira;

    public LocacaoChurrasqueiraDto(Long id, EstabelecimentoDto estab, AdministradorDto adm, LocalDate dataLocacao, Boolean ativo, ChurrasqueiraDto churrasqueira){
        this.id = id;
        this.estabelecimento = estab;
        this.administrador = adm;
        this.dataLocacao = dataLocacao;
        this.ativo = ativo;
        this.churrasqueira = churrasqueira;
    }
}
