package gerenciadorsociety.domains;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Campo {
    private Long id;
    private Integer numero;
    private Estabelecimento estabelecimento;
}
