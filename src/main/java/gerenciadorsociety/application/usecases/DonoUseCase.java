package gerenciadorsociety.application.usecases;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.exceptions.dono.DonoJaCadastradoException;
import gerenciadorsociety.application.exceptions.dono.DonoNaoEncontradoException;
import gerenciadorsociety.application.gateways.DonoGateway;
import gerenciadorsociety.domain.usuarios.Dono;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DonoUseCase {

    private final DonoGateway gateway;

    public Dono cadastrar(Dono novoDono) {
        Optional<Dono> donoExistente = gateway.buscarPorCpf(novoDono.getCpf());
        donoExistente.ifPresent(dono -> {
            throw new DonoJaCadastradoException();
        });

        return gateway.salvar(novoDono);
    }

    public Dono buscarPorCpf(String cpf) {
        Optional<Dono> donoExistente = gateway.buscarPorCpf(cpf);

        if (donoExistente.isEmpty())
            throw new DonoNaoEncontradoException();

        return donoExistente.get();
    }

    public Dono buscarPorId(Long id) {
        Optional<Dono> dono = gateway.buscarPorId(id);

        if (dono.isEmpty())
            throw new DonoNaoEncontradoException();

        return dono.get();
    }

    public Dono alterar(Long id, Dono novosDados) {
        Dono donoExistente = buscarPorId(id);

        donoExistente.alterarInformacoes(novosDados);

        return gateway.salvar(donoExistente);
    }

    public void deletar(Long id) {
        buscarPorId(id);

        gateway.deletar(id);
    }
}
