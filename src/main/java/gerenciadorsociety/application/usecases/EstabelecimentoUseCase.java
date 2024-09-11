package gerenciadorsociety.application.usecases;

import gerenciadorsociety.application.exceptions.estabelecimento.EstabelecimentoJaCadastradoException;
import gerenciadorsociety.application.exceptions.estabelecimento.EstabelecimentoNaoEncontradoException;
import gerenciadorsociety.application.gateways.EstabelecimentoGateway;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.domain.usuarios.Dono;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstabelecimentoUseCase {

    private final EstabelecimentoGateway gateway;
    private final DonoUseCase donoUseCase;

    public Estabelecimento cadastrar(Estabelecimento novoEstabelecimento) {
        Optional<Estabelecimento> estabelecimentotoExistente = gateway.consultarPorCnpj(novoEstabelecimento.getCnpj());

        estabelecimentotoExistente.ifPresent(estabelecimento -> {
            throw new EstabelecimentoJaCadastradoException();
        });

        Dono dono = donoUseCase.buscarPorCpf(novoEstabelecimento.getDono().getCpf());
        novoEstabelecimento.setDono(dono);
        return gateway.salvar(novoEstabelecimento);
    }

    public List<Estabelecimento> getEstabelecimentos() {
        return gateway.consultarTodos();
    }

    public void deletar(Long id) {
        buscarPorId(id);

        gateway.deletar(id);
    }

    public Estabelecimento consultarPorCnpj(String cnpj) {
        Optional<Estabelecimento> estabelecimentoExistente = gateway.consultarPorCnpj(cnpj);
        if (estabelecimentoExistente.isEmpty())
            throw new EstabelecimentoNaoEncontradoException();
        return estabelecimentoExistente.get();
    }

    public Estabelecimento buscarPorId(Long id) {
        Optional<Estabelecimento> estabelecimento = gateway.consultarPorId(id);
        if (estabelecimento.isEmpty())
            throw new EstabelecimentoNaoEncontradoException();
        return estabelecimento.get();
    }

    public Estabelecimento alterar(Estabelecimento novosDados, Long id) {
        Estabelecimento estabelecimentoExistente = buscarPorId(id);
        estabelecimentoExistente.alterarInformacoes(novosDados);
        return gateway.salvar(estabelecimentoExistente);
    }
}
