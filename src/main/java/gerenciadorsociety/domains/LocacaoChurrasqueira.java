package gerenciadorsociety.domains;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
public class LocacaoChurrasqueira extends Locacao{
    private Churrasqueira churrasqueira;

    public LocacaoChurrasqueira(Long id, Estabelecimento estab, Administrador adm, LocalDate dataLocacao, LocalDate data, LocalTime horaLocacao, Boolean ativo, Churrasqueira churrasqueira){
        super(id, estab, adm, dataLocacao, data, horaLocacao, ativo);
        this.churrasqueira = churrasqueira;
    }
}
