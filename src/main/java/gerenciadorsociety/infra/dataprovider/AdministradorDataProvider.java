package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.Administrador;
import gerenciadorsociety.infra.entitys.AdministradorEntity;
import gerenciadorsociety.infra.mappers.AdministradorMapper;
import gerenciadorsociety.infra.repositorys.AdministradorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdministradorDataProvider {

    private final AdministradorRepository repository;

    public Administrador salvar(Administrador adm){
        AdministradorEntity admEntity = AdministradorMapper.paraEntityDeDomain(adm);
        admEntity = repository.save(admEntity);
        return AdministradorMapper.paraDomainDeEntiy(admEntity);
    }

    public Administrador consultar(String cpf){
        AdministradorEntity admEntity = repository.getReferenceByCpf(cpf);
        return AdministradorMapper.paraDomainDeEntiy(admEntity);
    }

    public void deletar(String cpf){
        repository.deleteById(cpf);
    }
}
