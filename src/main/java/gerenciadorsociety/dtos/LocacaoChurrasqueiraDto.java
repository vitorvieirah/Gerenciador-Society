package gerenciadorsociety.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class LocacaoChurrasqueiraDto extends LocacaoDto{
    private ChurrasqueiraDto churrasqueiraDto;
}
