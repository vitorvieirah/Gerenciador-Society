package gerenciadorsociety.domain.locacao;

import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.domain.usuarios.Administrador;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
public class LocacaoChurrasqueira extends Locacao {

    private Churrasqueira churrasqueira;

    public LocacaoChurrasqueira(Long id, Estabelecimento estab, Administrador adm, LocalDate dataLocacao, LocalDate data, LocalTime horaLocacao, Boolean ativo, Churrasqueira churrasqueira) {
        super(id, estab, adm, dataLocacao, data, horaLocacao, ativo);
        this.churrasqueira = churrasqueira;
    }
}
