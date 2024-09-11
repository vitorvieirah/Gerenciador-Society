package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.gateways.AdministradorGateway;
import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.administrador.BuscaAdministradorPorCpfException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.administrador.BuscaAdministradorPorIdException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.administrador.DeletarAdministradorException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.administrador.SalvarAdministradorException;
import gerenciadorsociety.infrastructure.mappers.Mapper;
import gerenciadorsociety.infrastructure.repositories.AdministradorRepository;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.AdministradorEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class AdministradorDataProvider implements AdministradorGateway {

    private final AdministradorRepository repository;
    private final Mapper<Administrador, AdministradorEntity> mapper;

    @Override
    public Optional<Administrador> consultarPorCpf(String cpf) {
        Optional<AdministradorEntity> administradorEntity;
        try {
            administradorEntity = repository.findByCpf(cpf);
        } catch (Exception ex) {
            log.error("Erro ao consultar Administrador por cpf.", ex);
            throw new BuscaAdministradorPorCpfException(ex.getMessage());
        }
        return administradorEntity.map(mapper::paraDomain);
    }

    @Override
    public Optional<Administrador> consultarPorId(Long id) {
        Optional<AdministradorEntity> administradorEntity;
        try {
            administradorEntity = repository.findById(id);
        } catch (Exception ex) {
            log.error("Erro ao consultar administrador por id.", ex);
            throw new BuscaAdministradorPorIdException(ex.getMessage());
        }
        return administradorEntity.map(mapper::paraDomain);
    }

    @Override
    public Administrador salvar(Administrador adm) {
        AdministradorEntity admEntity = mapper.paraEntity(adm);
        try {
            admEntity = repository.save(admEntity);
        } catch (Exception ex) {
            log.error("Erro ao salvar administrador.", ex);
            throw new SalvarAdministradorException(ex.getMessage());
        }
        return mapper.paraDomain(admEntity);
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar administrador.", ex);
            throw new DeletarAdministradorException(ex.getMessage());
        }
    }
}
