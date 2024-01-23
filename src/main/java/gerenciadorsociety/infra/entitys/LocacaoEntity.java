package gerenciadorsociety.infra.entitys;

import gerenciadorsociety.domains.Administrador;
import gerenciadorsociety.domains.Estabelecimento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Entity(name = "Locacao")
@Table(name = "locacaoes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_locacao", discriminatorType = DiscriminatorType.STRING)
public abstract class LocacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Estabelecimento estabelecimento;
    private Administrador administrador;
    private LocalDate dataLocacao;
    private Boolean ativo;

}


