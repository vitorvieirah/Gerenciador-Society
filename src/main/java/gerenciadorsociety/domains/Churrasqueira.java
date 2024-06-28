package gerenciadorsociety.domains;

import lombok.*;

@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Builder
public class Churrasqueira {
    @EqualsAndHashCode.Include private Long id;
    private Integer numero;
    private Estabelecimento estabelecimento;
}
