package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.LocacaoChurrasqueira;
import gerenciadorsociety.infra.entitys.LocacaoChurrasqueiraEntity;
import gerenciadorsociety.infra.execptions.DataBaseExecption;
import gerenciadorsociety.infra.mappers.LocacaoChurrasqueiraMapper;
import gerenciadorsociety.infra.repositorys.LocacaoChurrasqueiraRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class LocacaoChurrasqueiraDataProvider {

    private final LocacaoChurrasqueiraRepository repository;


    public LocacaoChurrasqueira salvar(LocacaoChurrasqueira locacaoChurrasqueira) {
        LocacaoChurrasqueiraEntity entity = LocacaoChurrasqueiraMapper.paraEntityDeDomain(locacaoChurrasqueira);
        try{
            entity = repository.save(entity);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new DataBaseExecption(ex.getMessage());
        }

        return LocacaoChurrasqueiraMapper.paraDomainDeEntity(entity);
    }
}
