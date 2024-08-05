package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.gateways.EstabelecimentoGateway;
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
public class EstabelecimentoDataProvider implements EstabelecimentoGateway {

    private final EstabelecimentoRepository repository;

    @Override
    public Estabelecimento salvar(Estabelecimento estab) {
        EstabelecimentoEntity estabelecimentoEntity = EstabelecimentoMapper.paraEntityDeDomain(estab);
        try {
            estabelecimentoEntity = repository.save(estabelecimentoEntity);
        } catch (Exception ex) {
            log.error("Erro ao salvar Estabelecimento", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return EstabelecimentoMapper.paraDomainDeEntity(estabelecimentoEntity);
    }

    @Override
    public List<Estabelecimento> consultarTodos() {
        try {
            return EstabelecimentoMapper.paraDomainsDeEntitys(repository.findAll());
        } catch (Exception ex) {
            log.error("Erro ao consultar todos os Estabelecimentos", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

    @Override
    public Optional<Estabelecimento> consultarPorCnpj(String cnpj) {
        Optional<EstabelecimentoEntity> estabelecimentoEntity;
        try {
            estabelecimentoEntity = repository.findByCnpj(cnpj);
        } catch (Exception ex) {
            log.error("Erro ao consultar Estabelecimento", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return estabelecimentoEntity.map(EstabelecimentoMapper::paraDomainDeEntity);
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar Estabelecimento", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

    @Override
    public Optional<Estabelecimento> consultarPorId(Long id) {
        Optional<EstabelecimentoEntity> estabelecimentoEntity;

        try{
            estabelecimentoEntity = repository.findById(id);
        }catch (Exception ex){
            log.error("Erro ao buscar estabelecimento por id");
            throw new DataProviderExecption(ex.getMessage());
        }
        return estabelecimentoEntity.map(EstabelecimentoMapper::paraDomainDeEntity);
    }
}
