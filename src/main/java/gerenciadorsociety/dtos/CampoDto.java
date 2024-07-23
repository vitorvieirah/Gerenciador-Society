package gerenciadorsociety.dtos;

import lombok.Builder;

@Builder
public record CampoDto(Long id, Integer numero, EstabelecimentoDto estabelecimento) {
}
