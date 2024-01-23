package gerenciadorsociety.domains;

import lombok.*;

import java.time.LocalDate;


@Getter
@ToString
@Builder
public class LocacaoChurrasqueira extends Locacao{
    private Churrasqueira churrasqueira;
}
