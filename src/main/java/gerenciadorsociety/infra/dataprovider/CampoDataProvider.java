package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.infra.entitys.CampoEntity;
import gerenciadorsociety.infra.mappers.CampoMapper;
import gerenciadorsociety.infra.repositorys.CampoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CampoDataProvider {

    private final CampoRepository repository;

    public Campo salvar(Campo campo){
        CampoEntity campoEntity = CampoMapper.paraEntityDeDomain(campo);
        campoEntity = repository.save(campoEntity);
        return CampoMapper.paraDomainDeEntity(campoEntity);
    }

    public List<Campo> consultarTodos(){
        return CampoMapper.paraDomainsDeEntitys(repository.findAll());
    }

    public Campo consultarPorId(Long id){
        CampoEntity campoEntity = repository.getReferenceById(id);
        return CampoMapper.paraDomainDeEntity(campoEntity);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
