package gerenciadorsociety.application.services;

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
    private final Validacoes<Dono> validacoes;

    public DonoDto cadastrar(DonoDto dto) {
        Optional<Dono> dono = dataProvider.consultarPorCpf(dto.cpf());
        validacoes.validacaoObjetoPresente(dono, "Dono ja cadastrado");

        return DonoMapper.paraDtoDeDomain(dataProvider.salvar(DonoMapper.paraDomainDeDto(dto)));
    }

    public Dono buscarPorCpf(String cpf) {
        Optional<Dono> donoOptional = dataProvider.consultarPorCpf(cpf);
        validacoes.validacaoObjetoVazio(donoOptional, "Dono não encontrado");
        return donoOptional.get();
    }
}
