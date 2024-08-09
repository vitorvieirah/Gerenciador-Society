package gerenciadorsociety.application.gateways;

import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.infrastructure.repositories.entities.ChurrasqueiraEntity;

import java.util.List;
import java.util.Optional;

public interface ChurrasqueiraGateway {

    Churrasqueira salvar(Churrasqueira churrasqueira);
    void deletar(Long id);
    Optional<Churrasqueira> buscarPorNumero(Integer numero);
    List<Churrasqueira> buscarPorEstabelecimento(Long idEstabelecimento);

    Optional<Churrasqueira> buscarPorId(Long id);
}
