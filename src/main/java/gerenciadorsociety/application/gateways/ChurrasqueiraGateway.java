package gerenciadorsociety.application.gateways;

import gerenciadorsociety.domain.Churrasqueira;

import java.util.Optional;

public interface ChurrasqueiraGateway {

    Churrasqueira salvar(Churrasqueira churrasqueira);
    void deletar(Long id);
    Optional<Churrasqueira> buscarPorNumero(Integer numero);
}
