package gerenciadorsociety.domains;

import lombok.*;

@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Builder
public class Churrasqueira {
    private Long id;
    private Integer numero;
    private Estabelecimento estabelecimento;
}
