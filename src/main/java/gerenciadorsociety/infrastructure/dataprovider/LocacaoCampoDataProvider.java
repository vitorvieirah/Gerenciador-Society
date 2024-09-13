package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.gateways.LocacaoCampoGateway;
import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.locacao.locacaoCampo.*;
import gerenciadorsociety.infrastructure.mappers.Mapper;
import gerenciadorsociety.infrastructure.repositories.LocacaoCampoRepository;
import gerenciadorsociety.infrastructure.repositories.entities.locacao.LocacaoCampoEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class LocacaoCampoDataProvider implements LocacaoCampoGateway {

    private final LocacaoCampoRepository repository;
    private final Mapper<LocacaoCampo, LocacaoCampoEntity> mapper;

    @Override
    public LocacaoCampo salvar(LocacaoCampo locacaoCampo) {
        LocacaoCampoEntity entity = mapper.paraEntity(locacaoCampo);
        try {
            entity = repository.save(entity);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new SalvarLocacaoCampoException(ex.getMessage());
        }
        return mapper.paraDomain(entity);
    }

    @Override
    public Optional<LocacaoCampo> buscarPorId(Long id) {
        Optional<LocacaoCampoEntity> locacaoCampoEntity;
        try {
            locacaoCampoEntity = repository.findById(id);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new BuscarPorIdLocacaoCampoException(ex.getMessage());
        }

        return locacaoCampoEntity.map(mapper::paraDomain);
    }

    @Override
    public Optional<LocacaoCampo> buscarPorHoraLocacao(LocalTime hora, LocalDate data, Integer numeroCampo) {
        Optional<LocacaoCampoEntity> locacaoCampoEntity;
        try {
            locacaoCampoEntity = repository.findLocacaoValidacao(hora, data, numeroCampo);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new BuscarPorHoraLocacaoException(ex.getMessage());
        }
        return locacaoCampoEntity.map(mapper::paraDomain);
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DeletarLocacaoCampoException(ex.getMessage());
        }
    }

    @Override
    public List<LocacaoCampo> consultarTodasLocacoesPorAdministrador(Long idAministrador) {
        List<LocacaoCampoEntity> locacaoList;
        try {
            locacaoList = repository.consultarLocacoesPorAdministrador(idAministrador);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new ConsultarTodasLocacaoesCampoPorAdministradorException(ex.getMessage());
        }
        return mapper.paraDomains(locacaoList);
    }
}
