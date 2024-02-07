package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.Locacao;
import gerenciadorsociety.domains.LocacaoCampo;
import gerenciadorsociety.infra.entitys.LocacaoCampoEntity;
import gerenciadorsociety.infra.execptions.DataBaseExecption;
import gerenciadorsociety.infra.mappers.LocacaoCampoMapper;
import gerenciadorsociety.infra.repositorys.LocacaoCampoRepository;
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
public class LocacaoCampoDataProvider {

    private final LocacaoCampoRepository repository;


    public LocacaoCampo salvar(LocacaoCampo locacaoCampo) {
        LocacaoCampoEntity entity = LocacaoCampoMapper.paraEntityDeDomain(locacaoCampo);
        try {
            entity = repository.save(entity);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return LocacaoCampoMapper.paraDomainDeEntity(entity);
    }

    public Optional<LocacaoCampo> buscarPorId(Long id) {
        Optional<LocacaoCampoEntity> locacaoCampoEntity;
        try{
            locacaoCampoEntity = repository.findById(id);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new DataBaseExecption(ex.getMessage());
        }

        return locacaoCampoEntity.map(LocacaoCampoMapper::paraDomainDeEntity);
    }

    public Optional<LocacaoCampo> buscarPorHoraLocacao (LocalTime hora, LocalDate data, Integer numeroCampo){
        Optional<LocacaoCampoEntity> locacaoCampoEntity;
        try{
            locacaoCampoEntity = repository.findByLocacaoValidacao(hora, data, numeroCampo);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return locacaoCampoEntity.map(LocacaoCampoMapper::paraDomainDeEntity);
    }

    public void deletar(Long id) {
        Optional<LocacaoCampoEntity> locacaoCampoEntity;
        try{
            locacaoCampoEntity = repository.findById(id);
            locacaoCampoEntity.ifPresent(loc -> {
                repository.deleteById(id);
            });
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new DataBaseExecption(ex.getMessage());
        }
    }

    public List<LocacaoCampo> getAll() {
        List<LocacaoCampoEntity> locacaoList;
        try{
            locacaoList = repository.findAll();
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return LocacaoCampoMapper.paraDomainsDeEntitys(locacaoList);
    }
}
