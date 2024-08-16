package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.gateways.LocacaoChurrasqueiraGateway;
import gerenciadorsociety.domain.locacao.LocacaoChurrasqueira;
import gerenciadorsociety.infrastructure.repositories.entities.locacao.LocacaoChurrasqueiraEntity;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.DataProviderExecption;
import gerenciadorsociety.infrastructure.mappers.LocacaoChurrasqueiraMapper;
import gerenciadorsociety.infrastructure.repositories.LocacaoChurrasqueiraRepository;
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
public class LocacaoChurrasqueiraDataProvider implements LocacaoChurrasqueiraGateway {

    private final LocacaoChurrasqueiraRepository repository;

    public LocacaoChurrasqueira salvar(LocacaoChurrasqueira locacaoChurrasqueira) {
        LocacaoChurrasqueiraEntity locacao = LocacaoChurrasqueiraMapper.paraEntityDeDomain(locacaoChurrasqueira);
        try {
            locacao = repository.save(locacao);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }

        return LocacaoChurrasqueiraMapper.paraDomainDeEntity(locacao);
    }

    public Optional<LocacaoChurrasqueira> buscarLocacaoParaValidacao(LocalTime horaLocacao, LocalDate dataLocacao, Integer numeroChurrasqueira) {
        Optional<LocacaoChurrasqueiraEntity> locacao;
        try {
            locacao = repository.findByLocacaoValidacao(horaLocacao, dataLocacao, numeroChurrasqueira);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return locacao.map(LocacaoChurrasqueiraMapper::paraDomainDeEntity);
    }

    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

    @Override
    public List<LocacaoChurrasqueira> consultarTodasPorAdminsitrador(Long idAdministrador) {
        List<LocacaoChurrasqueiraEntity> locacoes;
        try {
            locacoes = repository.consultarPorAdministrador(idAdministrador);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }

        return LocacaoChurrasqueiraMapper.paraDomainsDeEntitys(locacoes);
    }

    public Optional<LocacaoChurrasqueira> buscarPorId(Long id) {
        Optional<LocacaoChurrasqueiraEntity> locacao;
        try {
            locacao = repository.findById(id);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return locacao.map(LocacaoChurrasqueiraMapper::paraDomainDeEntity);
    }
}
