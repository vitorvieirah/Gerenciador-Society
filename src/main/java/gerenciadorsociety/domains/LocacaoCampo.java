package gerenciadorsociety.domains;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class LocacaoCampo extends Locacao{
    private Campo campo;

    public LocacaoCampo(Long id, Estabelecimento estab, Administrador adm, LocalDate dataLocacao, Boolean ativo, Campo campo){
        this.id = id;
        this.estabelecimento = estab;
        this.administrador = adm;
        this.dataLocacao = dataLocacao;
        this.ativo = ativo;
        this.campo = campo;
    }
}
