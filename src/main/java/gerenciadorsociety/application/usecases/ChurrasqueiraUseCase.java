package gerenciadorsociety.application.usecases;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.exceptions.churrasqueira.ChurrasqueiraJaCadastradaException;
import gerenciadorsociety.application.exceptions.churrasqueira.ChurrasqueiraNaoEcontradaException;
import gerenciadorsociety.application.gateways.ChurrasqueiraGateway;
import gerenciadorsociety.domain.Churrasqueira;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChurrasqueiraUseCase {

    private final ChurrasqueiraGateway gateway;
    private final EstabelecimentoUseCase estabelecimentoUseCase;

    public Churrasqueira cadastrar(Churrasqueira novaChurrasqueira) {
        Optional<Churrasqueira> churrasqueiraOptional = gateway.buscarPorNumero(novaChurrasqueira.getNumero());

        churrasqueiraOptional.ifPresent(churrasqueira -> {
            throw new ChurrasqueiraJaCadastradaException();
        });

        novaChurrasqueira.setEstabelecimento(estabelecimentoUseCase.consultarPorCnpj(novaChurrasqueira.getEstabelecimento().getCnpj()));

        return gateway.salvar(novaChurrasqueira);
    }

    public Churrasqueira alterar(Long id, Churrasqueira novosDados) {
        var churasqueira = buscarPorId(id);
        churasqueira.atualizarInformacoes(novosDados);
        return gateway.salvar(churasqueira);
    }

    public Churrasqueira buscarPorNumero(Integer numero) {
        Optional<Churrasqueira> churrasqueiraOptional = gateway.buscarPorNumero(numero);
        if (churrasqueiraOptional.isEmpty())
            throw new ChurrasqueiraNaoEcontradaException();
        return churrasqueiraOptional.get();
    }

    public void deletar(Long id) {
        buscarPorId(id);
        gateway.deletar(id);
    }

    public List<Churrasqueira> buscarPorEstabelecimento(Long idEstabelecimento) {
        return gateway.buscarPorEstabelecimento(idEstabelecimento);
    }

    public Churrasqueira buscarPorId(Long id) {
        Optional<Churrasqueira> churrasqueira = gateway.buscarPorId(id);

        if (churrasqueira.isEmpty())
            throw new ChurrasqueiraNaoEcontradaException();

        return churrasqueira.get();
    }
}
