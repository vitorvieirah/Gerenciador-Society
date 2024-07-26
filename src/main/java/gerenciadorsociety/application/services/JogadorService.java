package gerenciadorsociety.application.services;

import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.infrastructure.dataprovider.LocacaoCampoDataProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JogadorService {

    private final LocacaoCampoDataProvider locacaoCampoDataProvider;

    public void entrarNaLista(Long idCampo, String nomeJogador) {
        LocacaoCampo locacao = getLocacaoPorIdCampo(idCampo);

        locacao.setListaDeJogadores(Optional.ofNullable(locacao.getListaDeJogadores()).orElseGet(ArrayList::new));

        locacao.getListaDeJogadores().stream()
                .filter(jogador -> jogador.equals(nomeJogador))
                .findFirst()
                .ifPresent(jogador -> {
                    throw new RuntimeException("Jogador já está na lista");
                });

        locacao.adicionarJogador(nomeJogador);
        locacaoCampoDataProvider.salvar(locacao);
    }

    public void sairDeUmaLista(Long id, String dto) {
        LocacaoCampo locacao = getLocacaoPorIdCampo(id);
        locacao.removeJogador(dto);
        locacaoCampoDataProvider.salvar(locacao);
    }

    private LocacaoCampo getLocacaoPorIdCampo(Long idCampo) {
        return locacaoCampoDataProvider.buscarPorId(idCampo).orElseThrow(() -> new RuntimeException("Locacao não existe"));
    }
}
