package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.gateways.LocacaoCampoGateway;
import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.infrastructure.repositories.entities.locacao.LocacaoCampoEntity;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.DataProviderExecption;
import gerenciadorsociety.infrastructure.mappers.LocacaoCampoMapper;
import gerenciadorsociety.infrastructure.repositories.LocacaoCampoRepository;
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
public class LocacaoCampoDataProvider implements LocacaoCampoGateway {

    private final LocacaoCampoRepository repository;

    @Override
    public LocacaoCampo salvar(LocacaoCampo locacaoCampo) {
        LocacaoCampoEntity entity = LocacaoCampoMapper.paraEntityDeDomain(locacaoCampo);
        try {
            entity = repository.save(entity);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return LocacaoCampoMapper.paraDomainDeEntity(entity);
    }

    @Override
    public Optional<LocacaoCampo> buscarPorId(Long id) {
        Optional<LocacaoCampoEntity> locacaoCampoEntity;
        try {
            locacaoCampoEntity = repository.findById(id);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }

        return locacaoCampoEntity.map(LocacaoCampoMapper::paraDomainDeEntity);
    }

    @Override
    public Optional<LocacaoCampo> buscarPorHoraLocacao(LocalTime hora, LocalDate data, Integer numeroCampo) {
        Optional<LocacaoCampoEntity> locacaoCampoEntity;
        try {
            locacaoCampoEntity = repository.findLocacaoValidacao(hora, data, numeroCampo);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return locacaoCampoEntity.map(LocacaoCampoMapper::paraDomainDeEntity);
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

    @Override
    public List<LocacaoCampo> consultarTodos() {
        List<LocacaoCampoEntity> locacaoList;
        try {
            locacaoList = repository.findAll();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return LocacaoCampoMapper.paraDomainsDeEntitys(locacaoList);
    }
}
