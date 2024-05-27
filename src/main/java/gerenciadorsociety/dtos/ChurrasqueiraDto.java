package gerenciadorsociety.dtos;

import lombok.Builder;

@Builder
public record ChurrasqueiraDto(Long id, Integer numero, EstabelecimentoDto estabelecimento) {
}
