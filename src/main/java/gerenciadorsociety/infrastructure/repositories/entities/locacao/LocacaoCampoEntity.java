package gerenciadorsociety.infrastructure.repositories.entities.locacao;

import gerenciadorsociety.infrastructure.repositories.entities.CampoEntity;
import gerenciadorsociety.infrastructure.repositories.entities.EstabelecimentoEntity;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.AdministradorEntity;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.JogadorEntity;
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
public class LocacaoCampoEntity extends LocacaoEntity {

    @ManyToOne
    @JoinColumn(name = "id_campo")
    private CampoEntity campo;
    @OneToMany
    private List<JogadorEntity> listaDeJogadores;

    public LocacaoCampoEntity(Long id, EstabelecimentoEntity estab, AdministradorEntity adm, LocalDate dataLocacao,
                              LocalDate data, LocalTime horaLocacao, Boolean ativo, CampoEntity campo, List<JogadorEntity> list) {
        super(id, estab, adm, dataLocacao, data, horaLocacao, ativo);
        this.campo = campo;
        this.listaDeJogadores = list;
    }
}
