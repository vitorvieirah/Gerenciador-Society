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
        super(id, estab, adm, dataLocacao, data, horaLocacao, ativo);
        this.campo = campo;
        this.listaDeJogadores = list;
    }

    public void adicionarJogador(String dto) {
        this.listaDeJogadores.add(dto);
    }

    public void removeJogador(String dto) {
        this.listaDeJogadores.remove(dto);
    }
}
