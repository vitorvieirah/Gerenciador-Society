package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.gateways.DonoGateway;
import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.infrastructure.repositories.entities.DonoEntity;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.DataProviderExecption;
import gerenciadorsociety.infrastructure.mappers.DonoMapper;
import gerenciadorsociety.infrastructure.repositories.DonoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class DonoDataProvider implements DonoGateway {

    private final DonoRepository repository;

    @Override
    public Dono salvar(Dono dono) {
        DonoEntity donoEntity = DonoMapper.paraEntityDeDomain(dono);
        try {
            donoEntity = repository.save(donoEntity);
        } catch (Exception ex) {
            log.error("Erro ao salvar Dono", ex);
            throw new DataProviderExecption(ex.getMessage());

        }
        return DonoMapper.paraDomainDeEntity(donoEntity);
    }

    @Override
    public Optional<Dono> buscarPorCpf(String cpf) {
        Optional<DonoEntity> donoEntity;
        try {
            donoEntity = repository.findByCpf(cpf);
        } catch (Exception ex) {
            log.error("Erro ao consultar Dono por Cpf", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return donoEntity.map(DonoMapper::paraDomainDeEntity);
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar Dono", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }
}
