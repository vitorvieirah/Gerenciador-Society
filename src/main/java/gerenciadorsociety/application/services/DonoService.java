package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.DonoGateway;
import gerenciadorsociety.application.mappers.Mapper;
import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.entrypoint.dtos.usuarios.DonoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DonoService {

    private final DonoGateway gateway;
    private final Mapper<Dono, DonoDto> mapper;
    private final String MENSAGEM_DONO_NAO_ENCONTRADO = "Dono não encontrado";

    public DonoDto cadastrar(DonoDto dto) {
        Optional<Dono> donoExistente = gateway.buscarPorCpf(dto.cpf());
        donoExistente.ifPresent(dono -> {
            throw new UseCaseException("Dono já cadastrado");
        });

        return mapper.paraDto(gateway.salvar(mapper.paraDomain(dto)));
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

        return mapper.paraDto(dono.get());
    }

    public DonoDto alterar(Long id, DonoDto novosDados) {
        Dono donoExistente = mapper.paraDomain(buscarPorId(id));

        donoExistente.alterarInformacoes(novosDados);

        return mapper.paraDto(gateway.salvar(donoExistente));
    }

    public void deletar(Long id) {
        gateway.deletar(id);
    }
}
