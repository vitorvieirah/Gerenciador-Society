package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.infra.entitys.CampoEntity;
import gerenciadorsociety.infra.execptions.DataBaseExecption;
import gerenciadorsociety.infra.mappers.CampoMapper;
import gerenciadorsociety.infra.repositorys.CampoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Component
@AllArgsConstructor
@Slf4j
public class CampoDataProvider {

    private final CampoRepository repository;

    public Campo salvar(Campo campo){
        CampoEntity campoEntity = CampoMapper.paraEntityDeDomain(campo);
        CampoEntity campoEntity1;
        try {
            campoEntity1 = repository.save(campoEntity);
        }catch (Exception ex){
            log.error("Erro ao salvar Campo", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return CampoMapper.paraDomainDeEntity(campoEntity);
    }

    public List<Campo> consultarTodos(){
        try {
            return CampoMapper.paraDomainsDeEntitys(repository.findAll());
        }catch (Exception ex){
            log.error("Erro ao consultar todos os campos", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
    }

    public Campo consultarPorId(Long id){
        CampoEntity campoEntity = null;
        try {
            campoEntity = repository.getReferenceById(id);
        }catch (Exception ex){
            log.error("Erro ao consultar campo por id", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return CampoMapper.paraDomainDeEntity(campoEntity);
    }

    public void deletar(Long id){
        try {
            repository.deleteById(id);
        }catch (Exception ex){
            log.error("Erro ao deletar campo", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
    }

    public Optional<Campo> buscarPorNumero (Integer numero){
        Optional<CampoEntity> campoEntity;
        try {
            campoEntity = repository.findByNumero(numero);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw new DataBaseExecption(ex.getMessage());
        }

        return campoEntity.map(CampoMapper::paraDomainDeEntity);
    }
}
