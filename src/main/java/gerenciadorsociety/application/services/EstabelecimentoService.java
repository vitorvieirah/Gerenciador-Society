package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.EstabelecimentoGateway;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.domain.usuarios.Dono;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoGateway gateway;
    private final DonoService donoService;

    public Estabelecimento cadastrar(Estabelecimento novoEstabelecimento) {
        Optional<Estabelecimento> estabelecimentotoExistente = gateway.consultarPorCnpj(novoEstabelecimento.getCnpj());

        estabelecimentotoExistente.ifPresent(estabelecimento -> {
            throw new UseCaseException("Estabelecimenot já cadastrado");
        });

        Dono dono = donoService.buscarPorCpf(novoEstabelecimento.getDono().getCpf());
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
            throw new UseCaseException("Estabelecimento não encontrado");
        return estabelecimentoExistente.get();
    }

    public Estabelecimento buscarPorId(Long id) {
        Optional<Estabelecimento> estabelecimento = gateway.consultarPorId(id);
        if (estabelecimento.isEmpty())
            throw new UseCaseException("Estabelecimento não econtrado");
        return estabelecimento.get();
    }

    public Estabelecimento alterar(Estabelecimento novosDados, Long id) {
        Estabelecimento estabelecimentoExistente = buscarPorId(id);
        estabelecimentoExistente.alterarInformacoes(novosDados);
        return gateway.salvar(estabelecimentoExistente);
    }
}
