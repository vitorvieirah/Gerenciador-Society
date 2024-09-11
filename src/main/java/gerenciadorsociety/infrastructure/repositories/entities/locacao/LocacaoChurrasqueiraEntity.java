package gerenciadorsociety.infrastructure.repositories.entities.locacao;

import gerenciadorsociety.infrastructure.repositories.entities.ChurrasqueiraEntity;
import gerenciadorsociety.infrastructure.repositories.entities.EstabelecimentoEntity;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.AdministradorEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@ToString
@Entity(name = "LocacaoChurrasqueira")
@Table(name = "locacoes_churrasqueiras")
@DiscriminatorValue("CHURRASQUEIRA")
public class LocacaoChurrasqueiraEntity extends LocacaoEntity {

    @ManyToOne
    @JoinColumn(name = "id_churrasqueira")
    private ChurrasqueiraEntity churrasqueira;

    public LocacaoChurrasqueiraEntity(Long id, EstabelecimentoEntity estab, AdministradorEntity adm, LocalDate dataLocacao, LocalDate data, LocalTime horaLocacao, Boolean ativo, ChurrasqueiraEntity churrasqueira) {
        super(id, estab, adm, dataLocacao, data, horaLocacao, ativo);
        this.churrasqueira = churrasqueira;
    }
}