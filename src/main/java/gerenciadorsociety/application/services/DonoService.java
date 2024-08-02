package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.DonoGateway;
import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.entrypoint.dtos.usuarios.DonoDto;
import gerenciadorsociety.infrastructure.dataprovider.DonoDataProvider;
import gerenciadorsociety.infrastructure.mappers.DonoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DonoService {

    private final DonoGateway gateway;
    private final String MENSAGEM_DONO_NAO_ENCONTRADO = "Dono não encontrado";

    public DonoDto cadastrar(DonoDto dto) {
        Optional<Dono> donoExistente = gateway.buscarPorCpf(dto.cpf());
        donoExistente.ifPresent(dono -> {
            throw new UseCaseException("Dono já cadastrado");
        });

        return DonoMapper.paraDtoDeDomain(gateway.salvar(DonoMapper.paraDomainDeDto(dto)));
    }

    public Dono buscarPorCpf(String cpf) {
        Optional<Dono> donoExistente = gateway.buscarPorCpf(cpf);

        if (donoExistente.isEmpty())
            throw new UseCaseException(MENSAGEM_DONO_NAO_ENCONTRADO);

        return donoExistente.get();
    }

    public DonoDto buscarPorId(Long id) {
        Optional<Dono> dono = gateway.buscarPorId(id);

        if (dono.isEmpty())
            throw new UseCaseException(MENSAGEM_DONO_NAO_ENCONTRADO);

        return DonoMapper.paraDtoDeDomain(dono.get());
    }

    public DonoDto alterar(Long id, DonoDto novosDados) {
        Dono donoExistente = DonoMapper.paraDomainDeDto(buscarPorId(id));

        donoExistente.alterarInformacoes(novosDados);

        return DonoMapper.paraDtoDeDomain(gateway.salvar(donoExistente));
    }

    public void deletar(Long id) {
        gateway.deletar(id);
    }
}
