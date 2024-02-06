package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.infra.entitys.ChurrasqueiraEntity;
import gerenciadorsociety.infra.execptions.DataBaseExecption;
import gerenciadorsociety.infra.mappers.ChurrasqueiraMapper;
import gerenciadorsociety.infra.repositorys.ChurrasqueiraRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class ChurrasqueiraDataProvider {

    private final ChurrasqueiraRepository repository;

    public Churrasqueira salvar (Churrasqueira churrasqueira){
        ChurrasqueiraEntity churEntity = ChurrasqueiraMapper.paraEntityDeDomain(churrasqueira);
        try {
            churEntity = repository.save(churEntity);
        }catch (Exception ex){
            log.error("Erro ao salvar Churrasqueira", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return ChurrasqueiraMapper.paraDomainDeEntity(churEntity);
    }

    public List<Churrasqueira> consultarTodos (){
        try {
            return ChurrasqueiraMapper.paraDomainsDeEntitys(repository.findAll());
        }catch (Exception ex){
            log.error("Erro ao consultar todas as Churrasqueiras", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
    }

    public Churrasqueira consultarPorId (Long id){
        ChurrasqueiraEntity churEntity = null;
        try {
            churEntity = repository.getReferenceById(id);
        }catch (Exception ex){
            log.error("Erro ao consultar Churrasqueira por id", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return ChurrasqueiraMapper.paraDomainDeEntity(churEntity);
    }

    public void deletar (Long id){
        try{
            repository.deleteById(id);
        }catch (Exception ex){
            log.error("Erro ao deletar Churrasqueira", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
    }

    public Optional<Churrasqueira> buscarPorNumero (Integer numero){
        Optional<ChurrasqueiraEntity> churrasqueiraEntity;
        try{
            churrasqueiraEntity = repository.findByNumero(numero);
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return churrasqueiraEntity.map(ChurrasqueiraMapper::paraDomainDeEntity);
    }


}
