package gerenciadorsociety.entrypoint.dtos;

import lombok.Builder;

@Builder
public record CampoDto(Long id, Integer numero, EstabelecimentoDto estabelecimento) {
}
