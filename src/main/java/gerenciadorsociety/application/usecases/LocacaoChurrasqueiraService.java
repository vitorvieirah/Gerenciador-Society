package gerenciadorsociety.application.usecases;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.LocacaoChurrasqueiraGateway;
import gerenciadorsociety.domain.locacao.LocacaoChurrasqueira;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocacaoChurrasqueiraService {

    private final LocacaoChurrasqueiraGateway gateway;
    private final ChurrasqueiraUseCase churrasqueiraUseCase;
    private final AdministradorUseCase administradorUseCase;

    public LocacaoChurrasqueira locar(LocacaoChurrasqueira novosDados) {
        Optional<LocacaoChurrasqueira> locacaoExistente = gateway.buscarLocacaoParaValidacao(novosDados.getHoraLocacao(), novosDados.getDataLocacao(), novosDados.getChurrasqueira().getNumero());

        locacaoExistente.ifPresent(locacaoChurrasqueira -> {
            throw new UseCaseException("Locação já cadastrada");
        });

        novosDados.setChurrasqueira(churrasqueiraUseCase.buscarPorNumero(novosDados.getChurrasqueira().getNumero()));

        novosDados.setEstabelecimento(novosDados.getChurrasqueira().getEstabelecimento());

        novosDados.setAdministrador(administradorUseCase.consultarPorId(novosDados.getAdministrador().getId()));

        novosDados.setData(LocalDate.now());

        return gateway.salvar(novosDados);
    }

    public List<LocacaoChurrasqueira> buscarPorTodos(Long idAdministrador) {
        return gateway.consultarTodasPorAdminsitrador(idAdministrador);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        gateway.deletar(id);
    }

    public LocacaoChurrasqueira buscarPorId(Long id) {
        Optional<LocacaoChurrasqueira> locacaoChurrasqueira = gateway.buscarPorId(id);

        if (locacaoChurrasqueira.isEmpty())
            throw new UseCaseException("Locacão churrasqueira não encontrada");

        return locacaoChurrasqueira.get();
    }
}
