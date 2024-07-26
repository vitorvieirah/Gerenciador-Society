package gerenciadorsociety.domain;

import lombok.*;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
@Builder
public class Churrasqueira {

    @EqualsAndHashCode.Include
    private Long id;
    private Integer numero;
    private Estabelecimento estabelecimento;
}
