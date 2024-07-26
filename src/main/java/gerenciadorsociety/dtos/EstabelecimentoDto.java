package gerenciadorsociety.dtos;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record EstabelecimentoDto(Long id, String nome, String cnpj, DonoDto dono, BigDecimal valorHora) {
}
