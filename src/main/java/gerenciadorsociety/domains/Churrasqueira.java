package gerenciadorsociety.domains;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Churrasqueira {
    private Long id;
    private Integer numero;
    private Boolean reservada;
    private Estabelecimento estabelecimento;
}
