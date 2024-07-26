package gerenciadorsociety.infrastructure.dataprovider;

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
public class DonoDataProvider {

    private final DonoRepository repository;

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

    public Optional<Dono> consultarPorCpf(String cpf) {
        Optional<DonoEntity> donoEntity;
        try {
            donoEntity = repository.findByCpf(cpf);
        } catch (Exception ex) {
            log.error("Erro ao consultar Dono por Cpf", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return donoEntity.map(DonoMapper::paraDomainDeEntity);
    }

    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar Dono", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }
}
