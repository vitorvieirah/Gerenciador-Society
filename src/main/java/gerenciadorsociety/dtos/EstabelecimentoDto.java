package gerenciadorsociety.dtos;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.domains.Dono;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record EstabelecimentoDto(Long id, String nome, String cnpj, DonoDto dono, BigDecimal valorHora) {
}
