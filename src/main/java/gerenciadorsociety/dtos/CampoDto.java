package gerenciadorsociety.dtos;

import gerenciadorsociety.domains.Estabelecimento;
import lombok.Builder;

@Builder
public record CampoDto(Long id, Integer numero, EstabelecimentoDto estabelecimento) {
}
