package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.domains.Dono;
import gerenciadorsociety.infra.entitys.DonoEntity;
import gerenciadorsociety.infra.execptions.DataBaseExecption;
import gerenciadorsociety.infra.mappers.DonoMapper;
import gerenciadorsociety.infra.repositorys.DonoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DonoDataProvider {

    private final DonoRepository repository;

    public Dono salvar (Dono dono){
        DonoEntity donoEntity = DonoMapper.paraEntityDeDomain(dono);
        try {
            donoEntity = repository.save(donoEntity);
        }catch (Exception ex){
            log.error("Erro ao salvar Dono", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return DonoMapper.paraDomainDeEntity(donoEntity);
    }

    public Dono consultarPorCpf (String cpf){
        DonoEntity donoEntity = null;
        try{
            donoEntity = repository.getReferenceByCpf(cpf);
        }catch (Exception ex){
            log.error("Erro ao consultar Dono por Cpf", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return DonoMapper.paraDomainDeEntity(donoEntity);
    }

    public void deletar (String cpf){
        try{
            repository.deleteById(cpf);
        }catch (Exception ex){
            log.error("Erro ao deletar Dono", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
    }
}
