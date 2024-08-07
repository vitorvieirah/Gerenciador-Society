package gerenciadorsociety.domain.locacao;

import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.domain.usuarios.Jogador;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class LocacaoCampo extends Locacao {

    private Campo campo;
    private List<Jogador> listaDeJogadores;

    public LocacaoCampo(Long id, Estabelecimento estab, Administrador adm, LocalDate dataLocacao, LocalDate data,
                        LocalTime horaLocacao, Boolean ativo, Campo campo, List<Jogador> list) {
        super(id, estab, adm, dataLocacao, data, horaLocacao, ativo);
        this.campo = campo;
        this.listaDeJogadores = list;
    }

    public void adicionarJogador(Jogador jogador) {
        this.listaDeJogadores.add(jogador);
    }

    public void removeJogador(Jogador jogador) {
        this.listaDeJogadores.remove(jogador);
    }
}
