package gerenciadorsociety.services;

import gerenciadorsociety.domains.LocacaoCampo;
import gerenciadorsociety.infra.dataprovider.LocacaoCampoDataProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class JogadorService {

    private final LocacaoCampoDataProvider dataProvider;



    public void entrarNaLista(Long id, String dto) {
        Optional<LocacaoCampo> locacao = validacaoOptional(id);

        locacao.get().getListaDeJogadores().forEach(jogador -> {
            if (jogador.equals(dto))
                throw new RuntimeException("Jogador ja está na lista");
        });

        locacao.get().adicionarJogador(dto);
    }

    public void sairDeUmaLista(Long id, String dto) {
        Optional<LocacaoCampo> locacao = validacaoOptional(id);
        locacao.get().removeJogador(dto);
    }

    private Optional<LocacaoCampo> validacaoOptional(Long id){

        Optional<LocacaoCampo> locacao = dataProvider.buscarPorId(id);

        if(locacao.isEmpty()){
            throw new RuntimeException("Locacao não existe");
        }

        return locacao;
    }
}
