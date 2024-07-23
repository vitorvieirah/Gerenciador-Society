package gerenciadorsociety.services;

import gerenciadorsociety.domains.LocacaoCampo;
import gerenciadorsociety.infra.dataprovider.LocacaoCampoDataProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LocacaoService {

    private final LocacaoCampoDataProvider locacaoCampoDataProvider;
    private final LocacaoChurrasqueiraService locacaoChurrasqueiraService;

    public void cancelar(Long id) {
        Optional<LocacaoCampo> locacaoCampo = locacaoCampoDataProvider.buscarPorId(id);
        if (locacaoCampo.isPresent()) {
            locacaoCampoDataProvider.deletar(id);
        } else {
            locacaoChurrasqueiraService.deletar(id);
        }
    }
}
