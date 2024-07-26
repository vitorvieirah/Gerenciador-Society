package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.infrastructure.repositories.entities.ChurrasqueiraEntity;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.DataProviderExecption;
import gerenciadorsociety.infrastructure.mappers.ChurrasqueiraMapper;
import gerenciadorsociety.infrastructure.repositories.ChurrasqueiraRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class ChurrasqueiraDataProvider {

    private final ChurrasqueiraRepository repository;

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

    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar Churrasqueira", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

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


}
