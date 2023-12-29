package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.domains.Dono;
import gerenciadorsociety.infra.entitys.DonoEntity;
import gerenciadorsociety.infra.mappers.DonoMapper;
import gerenciadorsociety.infra.repositorys.DonoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DonoDataProvider {

    private final DonoRepository repository;

    public Dono salvar (Dono dono){
        DonoEntity donoEntity = DonoMapper.paraEntityDeDomain(dono);
        donoEntity = repository.save(donoEntity);
        return DonoMapper.paraDomainDeEntity(donoEntity);
    }

    public Dono consultarPorCpf (String cpf){
        DonoEntity donoEntity = repository.getReferenceByCpf(cpf);
        return DonoMapper.paraDomainDeEntity(donoEntity);
    }

    public void deletar (String cpf){
        repository.deleteById(cpf);
    }
}
