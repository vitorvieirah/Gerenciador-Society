package gerenciadorsociety.domain;

import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import gerenciadorsociety.infrastructure.mappers.DonoMapper;
import gerenciadorsociety.infrastructure.mappers.EstabelecimentoMapper;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Setter
public class Estabelecimento {

    private Long id;
    private String nome;
    private String cnpj;
    private Dono dono;
    private BigDecimal valorHora;

    public void alterarInformacoes(EstabelecimentoDto novosDados) {
        if(novosDados.nome() != null)
            this.nome = novosDados.nome();
        if(novosDados.cnpj() != null)
            this.cnpj = novosDados.cnpj();
        if(novosDados.dono() != null)
            this.dono = DonoMapper.paraDomainDeDto(novosDados.dono());
        if(novosDados.valorHora() != null)
            this.valorHora = novosDados.valorHora();
    }
}
