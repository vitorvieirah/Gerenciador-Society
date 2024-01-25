package gerenciadorsociety.infra.entitys;

import gerenciadorsociety.domains.Churrasqueira;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
@Entity
@Table(name = "locacoes_churrasqueiras")
@DiscriminatorValue("CHURRASQUEIRA")
public class LocacaoChurrasqueiraEntity extends LocacaoEntity{
    private Churrasqueira churrasqueira;
}
