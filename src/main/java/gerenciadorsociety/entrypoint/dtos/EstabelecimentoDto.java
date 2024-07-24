package gerenciadorsociety.entrypoint.dtos;

import gerenciadorsociety.entrypoint.dtos.usuarios.DonoDto;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record EstabelecimentoDto(Long id, String nome, String cnpj, DonoDto dono, BigDecimal valorHora) {
}
