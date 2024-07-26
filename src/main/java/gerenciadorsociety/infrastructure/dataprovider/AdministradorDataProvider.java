package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.gateways.AdministradorGateway;
import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.infrastructure.repositories.entities.AdministradorEntity;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.DataProviderExecption;
import gerenciadorsociety.infrastructure.mappers.AdministradorMapper;
import gerenciadorsociety.infrastructure.repositories.AdministradorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class AdministradorDataProvider implements AdministradorGateway {

    private final AdministradorRepository repository;

    @Override
    public Optional<Administrador> consultarPorCpf(String cpf) {
        Optional<AdministradorEntity> administradorEntity;
        try {
            administradorEntity = repository.findByCpf(cpf);
        } catch (Exception ex) {
            log.error("Erro ao consultar Administrador", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return administradorEntity.map(AdministradorMapper::paraDomainDeEntiy);
    }

    @Override
    public Optional<Administrador> consultarPorId(Long id) {
        Optional<AdministradorEntity> administradorEntity;
        try{
            administradorEntity = repository.findById(id);
        }catch (Exception ex){
            log.error("Erro ao consultar administrador por id", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return administradorEntity.map(AdministradorMapper::paraDomainDeEntiy);
    }

    @Override
    public Administrador salvar(Administrador adm) {
        AdministradorEntity admEntity = AdministradorMapper.paraEntityDeDomain(adm);
        try {
            admEntity = repository.save(admEntity);
        } catch (Exception ex) {
            log.error("Erro ao salvar administrador", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return AdministradorMapper.paraDomainDeEntiy(admEntity);
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar Administrador", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }
}
