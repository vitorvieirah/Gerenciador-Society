package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.DonoGateway;
import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.DataProviderExecption;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.dono.BuscarPorCpfDonoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.dono.BuscarPorIdDonoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.dono.DeletarDonoException;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.dono.SalvarDonoException;
import gerenciadorsociety.infrastructure.mappers.Mapper;
import gerenciadorsociety.infrastructure.repositories.DonoRepository;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.DonoEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class DonoDataProvider implements DonoGateway {

    private final DonoRepository repository;
    private final Mapper<Dono, DonoEntity> mapper;

    @Override
    public Dono salvar(Dono dono) {
        DonoEntity donoEntity = mapper.paraEntity(dono);
        try {
            donoEntity = repository.save(donoEntity);
        } catch (Exception ex) {
            log.error("Erro ao salvar dono.", ex);
            throw new SalvarDonoException(ex.getMessage());

        }
        return mapper.paraDomain(donoEntity);
    }

    @Override
    public Optional<Dono> buscarPorCpf(String cpf) {
        Optional<DonoEntity> donoEntity;
        try {
            donoEntity = repository.findByCpf(cpf);
        } catch (Exception ex) {
            log.error("Erro ao consultar dono por cpf.", ex);
            throw new BuscarPorCpfDonoException(ex.getMessage());
        }
        return donoEntity.map(mapper::paraDomain);
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar dono.", ex);
            throw new DeletarDonoException(ex.getMessage());
        }
    }

    @Override
    public Optional<Dono> buscarPorId(Long id) {
        Optional<DonoEntity> donoExistente;
        try {
            donoExistente = repository.findById(id);
        } catch (Exception ex) {
            log.error("Erro ao buscar dono por id.", ex);
            throw new BuscarPorIdDonoException(ex.getMessage());
        }

        return donoExistente.map(mapper::paraDomain);
    }
}
