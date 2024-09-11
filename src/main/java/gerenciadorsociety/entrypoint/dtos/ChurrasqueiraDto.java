package gerenciadorsociety.entrypoint.dtos;

import lombok.Builder;

@Builder
public record ChurrasqueiraDto(Long id, Integer numero, EstabelecimentoDto estabelecimento) {
}
