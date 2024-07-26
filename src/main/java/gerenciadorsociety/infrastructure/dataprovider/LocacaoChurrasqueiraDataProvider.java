package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.domain.locacao.LocacaoChurrasqueira;
import gerenciadorsociety.infrastructure.repositories.entities.LocacaoChurrasqueiraEntity;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.DataProviderExecption;
import gerenciadorsociety.infrastructure.mappers.LocacaoChurrasqueiraMapper;
import gerenciadorsociety.infrastructure.repositories.LocacaoChurrasqueiraRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class LocacaoChurrasqueiraDataProvider {

    private final LocacaoChurrasqueiraRepository repository;

    public LocacaoChurrasqueira salvar(LocacaoChurrasqueira locacaoChurrasqueira) {
        LocacaoChurrasqueiraEntity entity = LocacaoChurrasqueiraMapper.paraEntityDeDomain(locacaoChurrasqueira);
        try {
            entity = repository.save(entity);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }

        return LocacaoChurrasqueiraMapper.paraDomainDeEntity(entity);
    }

    public Optional<LocacaoChurrasqueira> buscarLocacaoParaValidacao(LocalTime horaLocacao, LocalDate dataLocacao, Integer numeroChurrasqueira) {
        Optional<LocacaoChurrasqueiraEntity> locacaoChurrasqueiraEntity;
        try {
            locacaoChurrasqueiraEntity = repository.findByLocacaoValidacao(horaLocacao, dataLocacao, numeroChurrasqueira);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return locacaoChurrasqueiraEntity.map(LocacaoChurrasqueiraMapper::paraDomainDeEntity);
    }

    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

    public List<LocacaoChurrasqueira> consultarTodos() {
        List<LocacaoChurrasqueiraEntity> locacaoList;
        try {
            locacaoList = repository.findAll();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }

        return LocacaoChurrasqueiraMapper.paraDomainsDeEntitys(locacaoList);
    }

    public Optional<LocacaoChurrasqueira> buscarPorId(Long id) {
        Optional<LocacaoChurrasqueiraEntity> locacao;
        try {
            locacao = repository.findById(id);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return locacao.map(LocacaoChurrasqueiraMapper::paraDomainDeEntity);
    }
}
