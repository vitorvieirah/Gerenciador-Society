package gerenciadorsociety.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@Builder
public class LocacaoCampoDto extends LocacaoDto {
    private CampoDto campoDto;
}
