package gerenciadorsociety.infra.entitys;

import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.domains.LocacaoChurrasqueira;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "locacoes_churrasqueiras")
@DiscriminatorValue("CHURRASQUEIRA")
public class LocacaoChurrasqueiraEntity extends LocacaoEntity{
    @ManyToOne
    @JoinColumn(name = "id_churrasqueira", nullable = false)
    private ChurrasqueiraEntity churrasqueira;

    public LocacaoChurrasqueiraEntity(Long id, EstabelecimentoEntity estab, AdministradorEntity adm, LocalDate dataLocacao, Boolean ativo, ChurrasqueiraEntity churrasqueira){
        this.id = id;
        this.estabelecimento = estab;
        this.administrador = adm;
        this.dataLocacao = dataLocacao;
        this.ativo = ativo;
        this.churrasqueira = churrasqueira;
    }
}
