package gerenciadorsociety.domains;

import lombok.*;

import java.time.LocalDate;


@Getter
@ToString
@Builder
public class LocacaoCampo extends Locacao{
    private Campo campo;
}
