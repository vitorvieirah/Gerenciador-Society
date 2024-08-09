package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.gateways.ChurrasqueiraGateway;
import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.infrastructure.repositories.entities.ChurrasqueiraEntity;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.DataProviderExecption;
import gerenciadorsociety.infrastructure.mappers.ChurrasqueiraMapper;
import gerenciadorsociety.infrastructure.repositories.ChurrasqueiraRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class ChurrasqueiraDataProvider implements ChurrasqueiraGateway {

    private final ChurrasqueiraRepository repository;

    @Override
    public Churrasqueira salvar(Churrasqueira churrasqueira) {
        ChurrasqueiraEntity churEntity = ChurrasqueiraMapper.paraEntityDeDomain(churrasqueira);
        try {
            churEntity = repository.save(churEntity);
        } catch (Exception ex) {
            log.error("Erro ao salvar Churrasqueira", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return ChurrasqueiraMapper.paraDomainDeEntity(churEntity);
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar Churrasqueira", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

    @Override
    public Optional<Churrasqueira> buscarPorNumero(Integer numero) {
        Optional<ChurrasqueiraEntity> churrasqueiraEntity;
        try {
            churrasqueiraEntity = repository.findByNumero(numero);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return churrasqueiraEntity.map(ChurrasqueiraMapper::paraDomainDeEntity);
    }

    @Override
    public List<Churrasqueira> buscarPorEstabelecimento(Long idEstabelecimento) {
        try {
            return repository.buscarPorEstabelecimento(idEstabelecimento).stream().map(ChurrasqueiraMapper::paraDomainDeEntity).toList();
        }catch (Exception ex){
            log.error("Erro ao buscar churrasqueira por estabelecimento", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

    @Override
    public Optional<Churrasqueira> buscarPorId(Long id) {
        try{
            return repository.findById(id).map(ChurrasqueiraMapper::paraDomainDeEntity);
        }catch (Exception ex){
            log.error("Erro ao bucar churrasqueira por id", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }


}
