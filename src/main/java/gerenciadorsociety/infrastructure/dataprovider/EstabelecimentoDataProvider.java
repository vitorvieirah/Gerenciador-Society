package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.infrastructure.repositories.entities.EstabelecimentoEntity;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.DataProviderExecption;
import gerenciadorsociety.infrastructure.mappers.EstabelecimentoMapper;
import gerenciadorsociety.infrastructure.repositories.EstabelecimentoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class EstabelecimentoDataProvider {

    private final EstabelecimentoRepository repository;

    public Estabelecimento salvar(Estabelecimento estab) {
        EstabelecimentoEntity estabEntity = EstabelecimentoMapper.paraEntityDeDomain(estab);
        try {
            estabEntity = repository.save(estabEntity);
        } catch (Exception ex) {
            log.error("Erro ao salvar Estabelecimento", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return EstabelecimentoMapper.paraDomainDeEntity(estabEntity);
    }

    public List<Estabelecimento> consultarTodos() {
        try {
            return EstabelecimentoMapper.paraDomainsDeEntitys(repository.findAll());
        } catch (Exception ex) {
            log.error("Erro ao consultar todos os Estabelecimentos", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

    public Optional<Estabelecimento> consultarPorCnpj(String cnpj) {
        Optional<EstabelecimentoEntity> estabEntity;
        try {
            estabEntity = repository.findByCnpj(cnpj);
        } catch (Exception ex) {
            log.error("Erro ao consultar Estabelecimento", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return estabEntity.map(EstabelecimentoMapper::paraDomainDeEntity);
    }

    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar Estabelecimento", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }
}
