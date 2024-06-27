package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.Administrador;
import gerenciadorsociety.infra.entitys.AdministradorEntity;
import gerenciadorsociety.infra.execptions.DataBaseExecption;
import gerenciadorsociety.infra.mappers.AdministradorMapper;
import gerenciadorsociety.infra.repositorys.AdministradorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class AdministradorDataProvider implements DataProvider<Administrador> {

    private final AdministradorRepository repository;

    @Override
    public Administrador salvar(Administrador adm){
        AdministradorEntity admEntity = AdministradorMapper.paraEntityDeDomain(adm);
        try {
            admEntity = repository.save(admEntity);
        }catch (Exception ex){
            log.error("Erro ao salvar administrador", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return AdministradorMapper.paraDomainDeEntiy(admEntity);
    }

    public Optional<Administrador> consultar(String cpf){
        Optional<AdministradorEntity> admEntity;
        try {
             admEntity = repository.findByCpf(cpf);
        }catch (Exception ex){
            log.error("Erro ao consultar Administrador", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return admEntity.map(AdministradorMapper::paraDomainDeEntiy);
    }

    @Override
    public void deletar(Long id){
        try {
            repository.deleteById(id);
        }catch (Exception ex){
            log.error("Erro ao deletar Administrador", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
    }
}
