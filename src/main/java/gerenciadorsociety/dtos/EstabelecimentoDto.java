package gerenciadorsociety.dtos;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.domains.Dono;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record EstabelecimentoDto(String nome, String cnpj, String cpfDono, DonoDto dono, List<CampoDto> campos, List<ChurrasqueiraDto> churrasqueiras, BigDecimal valorHora) {
}
