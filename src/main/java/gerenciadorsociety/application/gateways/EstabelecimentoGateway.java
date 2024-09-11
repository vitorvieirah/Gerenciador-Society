package gerenciadorsociety.application.gateways;

import gerenciadorsociety.domain.Estabelecimento;

import java.util.List;
import java.util.Optional;

public interface EstabelecimentoGateway {
    Estabelecimento salvar(Estabelecimento estabelecimento);

    List<Estabelecimento> consultarTodos();

    Optional<Estabelecimento> consultarPorCnpj(String cnpj);

    void deletar(Long id);

    Optional<Estabelecimento> consultarPorId(Long id);
}
