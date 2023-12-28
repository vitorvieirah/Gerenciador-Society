package gerenciadorsociety.dtos;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.domains.Dono;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record EstabelecimentoDto(String nome, String cnpj, String cpfDono, Dono dono, List<Campo> campos, List<Churrasqueira> churrasqueiras, BigDecimal valorHora) {
}
