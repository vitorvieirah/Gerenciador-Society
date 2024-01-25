package gerenciadorsociety.dtos;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@ToString
public class LocacaoCampoDto extends LocacaoDto {
    private CampoDto campo;

    public LocacaoCampoDto(Long id, EstabelecimentoDto estab, AdministradorDto adm, LocalDate dataLocacao, Boolean ativo, CampoDto campo){
        this.id = id;
        this.estabelecimento = estab;
        this.administrador = adm;
        this.dataLocacao = dataLocacao;
        this.ativo = ativo;
        this.campo = campo;
    }
}
