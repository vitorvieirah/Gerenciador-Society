package gerenciadorsociety.domains;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Campo {
    private Long id;
    private Integer numero;
    private Boolean reservado;
}
