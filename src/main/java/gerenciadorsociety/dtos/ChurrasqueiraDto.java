package gerenciadorsociety.dtos;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ChurrasqueiraDto(Long id, Integer numero, Boolean reservado) {
}
