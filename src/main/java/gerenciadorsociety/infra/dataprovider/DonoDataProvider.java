package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.Dono;
import gerenciadorsociety.infra.entitys.DonoEntity;
import gerenciadorsociety.infra.execptions.DataBaseExecption;
import gerenciadorsociety.infra.mappers.DonoMapper;
import gerenciadorsociety.infra.repositorys.DonoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class DonoDataProvider implements DataProvider<Dono> {

    private final DonoRepository repository;

    @Override
    public Dono salvar(Dono dono) {
        DonoEntity donoEntity = DonoMapper.paraEntityDeDomain(dono);
        try {
            donoEntity = repository.save(donoEntity);
        } catch (Exception ex) {
            log.error("Erro ao salvar Dono", ex);
            throw new DataBaseExecption(ex.getMessage());

        }
        return DonoMapper.paraDomainDeEntity(donoEntity);
    }

    public Optional<Dono> consultarPorCpf(String cpf) {
        Optional<DonoEntity> donoEntity;
        try {
            donoEntity = repository.findByCpf(cpf);
        } catch (Exception ex) {
            log.error("Erro ao consultar Dono por Cpf", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return donoEntity.map(DonoMapper::paraDomainDeEntity);
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar Dono", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
    }
}
