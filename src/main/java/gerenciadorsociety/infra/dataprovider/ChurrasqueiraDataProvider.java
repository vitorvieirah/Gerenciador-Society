package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.infra.entitys.ChurrasqueiraEntity;
import gerenciadorsociety.infra.mappers.ChurrasqueiraMapper;
import gerenciadorsociety.infra.repositorys.ChurrasqueiraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ChurrasqueiraDataProvider {

    private final ChurrasqueiraRepository repository;

    public Churrasqueira salvar (Churrasqueira churrasqueira){
        ChurrasqueiraEntity churEntity = ChurrasqueiraMapper.paraEntityDeDomain(churrasqueira);
        churEntity = repository.save(churEntity);
        return ChurrasqueiraMapper.paraDomainDeEntity(churEntity);
    }

    public List<Churrasqueira> consultarTodos (){
        return ChurrasqueiraMapper.paraDomainsDeEntitys(repository.findAll());
    }

    public Churrasqueira consultarPorId (Long id){
        ChurrasqueiraEntity churEntity = repository.getReferenceById(id);
        return ChurrasqueiraMapper.paraDomainDeEntity(churEntity);
    }

    public void deletar (Long id){
        repository.deleteById(id);
    }


}
