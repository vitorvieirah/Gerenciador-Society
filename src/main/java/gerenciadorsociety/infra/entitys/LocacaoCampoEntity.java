package gerenciadorsociety.infra.entitys;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.domains.Estabelecimento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "locacaoes_campos")
@DiscriminatorValue("CAMPO")
public class LocacaoCampoEntity extends LocacaoEntity {
    private Campo campo;
}
