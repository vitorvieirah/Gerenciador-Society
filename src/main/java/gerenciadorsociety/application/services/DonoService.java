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
    private final DonoDataProvider dataProvider;
    private final DonoGateway gateway;

    public DonoDto cadastrar(DonoDto dto) {
        Optional<Dono> donoExistente = dataProvider.consultarPorCpf(dto.cpf());
        donoExistente.ifPresent(dono -> {
            throw new UseCaseException("Dono já cadastrado");
        });

        return DonoMapper.paraDtoDeDomain(dataProvider.salvar(DonoMapper.paraDomainDeDto(dto)));
    }

    public Dono buscarPorCpf(String cpf) {
        Optional<Dono> donoExistente = dataProvider.consultarPorCpf(cpf);

        if(donoExistente.isEmpty())
            throw new UseCaseException("Dono não encontrado");

        return donoExistente.get();
    }
}
