package gerenciadorsociety.services;

import gerenciadorsociety.domains.LocacaoCampo;
import gerenciadorsociety.infra.dataprovider.LocacaoCampoDataProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JogadorService {

    private final LocacaoCampoDataProvider dataProvider;



    public void entrarNaLista(Long id, String dto) {
        LocacaoCampo locacao = validacaoOptional(id);

        if(locacao.getListaDeJogadores() == null){
            locacao = criarListaJogadores(locacao);
        }else{
            locacao.getListaDeJogadores().forEach(jogador -> {
                if (jogador.equals(dto))
                    throw new RuntimeException("Jogador ja está na lista");
            });
        }


        locacao.adicionarJogador(dto);
        dataProvider.salvar(locacao);
    }

    public void sairDeUmaLista(Long id, String dto) {
        LocacaoCampo locacao = validacaoOptional(id);
        locacao.removeJogador(dto);
        dataProvider.salvar(locacao);
    }

    private LocacaoCampo validacaoOptional(Long id){

        Optional<LocacaoCampo> locacao = dataProvider.buscarPorId(id);

        if(locacao.isEmpty()){
            throw new RuntimeException("Locacao não existe");
        }

        return locacao.get();
    }

    private LocacaoCampo criarListaJogadores(LocacaoCampo locacao) {
        return new LocacaoCampo(locacao.getId(), locacao.getEstabelecimento(), locacao.getAdministrador(), locacao.getDataLocacao(),
                locacao.getData(), locacao.getHoraLocacao(), locacao.getAtivo(), locacao.getCampo(), new ArrayList<>()
        );
    }
}
