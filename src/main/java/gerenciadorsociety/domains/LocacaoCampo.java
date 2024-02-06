package gerenciadorsociety.domains;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@Getter
public class LocacaoCampo extends Locacao{
    private Campo campo;
    private List<String> listaDeJogadores;

    public LocacaoCampo(Long id, Estabelecimento estab, Administrador adm, LocalDate dataLocacao, LocalDate data, LocalTime horaLocacao, Boolean ativo, Campo campo, List<String> list){
        this.id = id;
        this.estabelecimento = estab;
        this.administrador = adm;
        this.dataLocacao = dataLocacao;
        this.data = data;
        this.horaLocacao = horaLocacao;
        this.ativo = ativo;
        this.campo = campo;
        this.listaDeJogadores = list;
    }
}
