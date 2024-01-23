package gerenciadorsociety.infra.entitys;

import gerenciadorsociety.domains.Campo;
import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Builder
@Entity
@Table(name = "locacaoes_campos")
@DiscriminatorValue("CAMPO")
public class LocacaoCampoEntity extends LocacaoEntity{
    private Campo campo;
}
