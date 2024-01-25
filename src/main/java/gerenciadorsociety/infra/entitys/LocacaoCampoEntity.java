package gerenciadorsociety.infra.entitys;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.domains.Estabelecimento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "locacaoes_campos")
@DiscriminatorValue("CAMPO")
public class LocacaoCampoEntity extends LocacaoEntity{
    @ManyToOne
    @JoinColumn(name = "id_campo", nullable = false)
    private CampoEntity campo;

    public LocacaoCampoEntity(Long id, EstabelecimentoEntity estab, AdministradorEntity adm, LocalDate dataLocacao, Boolean ativo, CampoEntity campo){
        this.id = id;
        this.estabelecimento = estab;
        this.administrador = adm;
        this.dataLocacao = dataLocacao;
        this.ativo = ativo;
        this.campo = campo;
    }
}
