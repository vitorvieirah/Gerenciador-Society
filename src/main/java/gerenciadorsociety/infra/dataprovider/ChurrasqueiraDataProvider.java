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
public class ChurrasqueiraDataProvider implements DataProvider<Churrasqueira>{

    private final ChurrasqueiraRepository repository;

    @Override
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

    @Override
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
