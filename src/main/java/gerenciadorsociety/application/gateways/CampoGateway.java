package gerenciadorsociety.application.gateways;

import gerenciadorsociety.domain.Campo;

import java.util.List;
import java.util.Optional;

public interface CampoGateway {

    Campo salvar(Campo campo);
    Optional<Campo> buscarPorNumero(int numero);
    void deletar(Long id);[]
    List<Campo> buscarPorEstabelecimento(Long idEstabelecimento);
}
