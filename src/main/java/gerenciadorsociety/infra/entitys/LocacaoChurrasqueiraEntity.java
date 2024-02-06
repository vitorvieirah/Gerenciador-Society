package gerenciadorsociety.infra.entitys;

import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.domains.LocacaoChurrasqueira;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

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

    public LocacaoChurrasqueiraEntity(Long id, EstabelecimentoEntity estab, AdministradorEntity adm, LocalDate dataLocacao, LocalDate data, LocalTime horaLocacao, Boolean ativo, ChurrasqueiraEntity churrasqueira){
        this.id = id;
        this.estabelecimento = estab;
        this.administrador = adm;
        this.dataLocacao = dataLocacao;
        this.data = data;
        this.horaLocacao = horaLocacao;
        this.ativo = ativo;
        this.churrasqueira = churrasqueira;
    }
}
