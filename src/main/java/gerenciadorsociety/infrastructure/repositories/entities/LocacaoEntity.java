package gerenciadorsociety.infrastructure.repositories.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity(name = "Locacao")
@Table(name = "locacoes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_locacao", discriminatorType = DiscriminatorType.STRING)
public abstract class LocacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    protected Long id;
    @ManyToOne
    @JoinColumn(name = "cnpj_estabelecimento", nullable = false)
    protected EstabelecimentoEntity estabelecimento;
    @ManyToOne
    @JoinColumn(name = "cpf_adm", nullable = false)
    protected AdministradorEntity administrador;
    protected LocalDate dataLocacao;
    protected LocalDate dataAtual;
    protected LocalTime horaLocacao;
    protected Boolean ativo;
}


