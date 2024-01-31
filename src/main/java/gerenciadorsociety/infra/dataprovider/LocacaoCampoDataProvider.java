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

    public Optional<Locacao> buscarPorId(Long id) {
        Optional<LocacaoCampoEntity> locacaoCampoEntity;
        try{
            locacaoCampoEntity = repository.findById(id);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new DataBaseExecption(ex.getMessage());
        }

        return locacaoCampoEntity.map(LocacaoCampoMapper::paraDomainDeEntity);
    }

}
