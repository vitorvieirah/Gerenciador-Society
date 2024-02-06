package gerenciadorsociety.services;

import gerenciadorsociety.domains.Dono;
import gerenciadorsociety.dtos.DonoDto;
import gerenciadorsociety.infra.dataprovider.DonoDataProvider;
import gerenciadorsociety.infra.mappers.DonoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DonoService {
    private final DonoDataProvider dataProvider;

    public DonoDto cadastrar(DonoDto dto) {
        Optional<Dono> dono = dataProvider.consultarPorCpf(dto.cpf());
        dono.ifPresent(dn -> {
            throw new RuntimeException("Dono ja cadastrado");
        });
        return DonoMapper.paraDtoDeDomain(dataProvider.salvar(DonoMapper.paraDomainDeDto(dto)));
    }
}
