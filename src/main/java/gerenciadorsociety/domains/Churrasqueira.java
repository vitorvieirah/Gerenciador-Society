package gerenciadorsociety.domains;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Churrasqueira {
    private Long id;
    private Integer numero;
    private Boolean reservada;
}
