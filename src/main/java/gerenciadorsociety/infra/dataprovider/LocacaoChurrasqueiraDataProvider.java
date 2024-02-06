package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.LocacaoChurrasqueira;
import gerenciadorsociety.infra.entitys.LocacaoChurrasqueiraEntity;
import gerenciadorsociety.infra.execptions.DataBaseExecption;
import gerenciadorsociety.infra.mappers.LocacaoCampoMapper;
import gerenciadorsociety.infra.mappers.LocacaoChurrasqueiraMapper;
import gerenciadorsociety.infra.repositorys.LocacaoChurrasqueiraRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

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

    public Optional<LocacaoChurrasqueira> buscarLocacaoParaValidacao (LocalTime horaLocacao, LocalDate dataLocacao, Integer numeroChurrasqueira){
        Optional<LocacaoChurrasqueiraEntity> locacaoChurrasqueiraEntity;
        try{
            locacaoChurrasqueiraEntity = repository.findByLocacaoValidacao(horaLocacao, dataLocacao, numeroChurrasqueira);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return locacaoChurrasqueiraEntity.map(LocacaoChurrasqueiraMapper::paraDomainDeEntity);
    }

    public void deletar(Long id) {
        Optional<LocacaoChurrasqueiraEntity> locacaoChurrasqueiraEntity;
        try {
            locacaoChurrasqueiraEntity = repository.findById(id);
            locacaoChurrasqueiraEntity.ifPresent(loc -> {
                repository.deleteById(id);
            });
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new DataBaseExecption(ex.getMessage());
        }
    }

    public List<LocacaoChurrasqueira> getAll() {
        List<LocacaoChurrasqueiraEntity> locacaoList;
        try{
            locacaoList = repository.findAll();
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new DataBaseExecption(ex.getMessage());
        }

        return LocacaoChurrasqueiraMapper.paraDomainsDeEntitys(locacaoList);
    }
}
