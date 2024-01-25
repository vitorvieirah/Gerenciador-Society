package gerenciadorsociety.domains;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@ToString
public class LocacaoChurrasqueira extends Locacao{
    private Churrasqueira churrasqueira;

    public LocacaoChurrasqueira(Long id, Estabelecimento estab, Administrador adm, LocalDate dataLocacao, Boolean ativo, Churrasqueira churrasqueira){
        this.id = id;
        this.estabelecimento = estab;
        this.administrador = adm;
        this.dataLocacao = dataLocacao;
        this.ativo = ativo;
        this.churrasqueira = churrasqueira;
    }
}
