package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.Dono;
import gerenciadorsociety.domains.Estabelecimento;
import gerenciadorsociety.infra.entitys.EstabelecimentoEntity;
import gerenciadorsociety.infra.mappers.EstabelecimentoMapper;
import gerenciadorsociety.infra.repositorys.EstabelecimentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EstabelecimentoDataProvider {

    private final EstabelecimentoRepository repository;

    public Estabelecimento salvar (Estabelecimento estab){
        EstabelecimentoEntity estabEntity = EstabelecimentoMapper.paraEntityDeDomain(estab);
        estabEntity = repository.save(estabEntity);
        return EstabelecimentoMapper.paraDomainDeEntity(estabEntity);
    }

    public List<Estabelecimento> consultarTodos (){
        return EstabelecimentoMapper.paraDomainsDeEntitys(repository.findAll());
    }

    public Estabelecimento consultarPorCnpj (String cnpj){
        EstabelecimentoEntity estabEntity = repository.getReferenceByCnpj(cnpj);
        return EstabelecimentoMapper.paraDomainDeEntity(estabEntity);
    }

    public void deletar (String cnpj){
        repository.deleteById(cnpj);
    }
}
