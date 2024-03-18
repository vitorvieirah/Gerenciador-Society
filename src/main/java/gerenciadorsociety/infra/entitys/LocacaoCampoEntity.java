package gerenciadorsociety.infra.entitys;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.domains.Estabelecimento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "locacaoes_campos")
@DiscriminatorValue("CAMPO")
public class LocacaoCampoEntity extends LocacaoEntity{
    @ManyToOne
    @JoinColumn(name = "id_campo")
    private CampoEntity campo;
    private List<String> listaDeJogadores;

    public LocacaoCampoEntity(Long id, EstabelecimentoEntity estab, AdministradorEntity adm, LocalDate dataLocacao, LocalDate data, LocalTime horaLocacao, Boolean ativo, CampoEntity campo, List<String> list){
        this.id = id;
        this.estabelecimento = estab;
        this.administrador = adm;
        this.dataLocacao = dataLocacao;
        this.data = data;
        this.horaLocacao = horaLocacao;
        this.ativo = ativo;
        this.campo = campo;
        this.listaDeJogadores = list;
    }
}
