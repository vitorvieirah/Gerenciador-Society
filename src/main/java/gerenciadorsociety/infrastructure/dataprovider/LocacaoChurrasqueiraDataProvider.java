package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.gateways.LocacaoChurrasqueiraGateway;
import gerenciadorsociety.domain.locacao.LocacaoChurrasqueira;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.locacao.locacaoChurrasqueira.*;
import gerenciadorsociety.infrastructure.mappers.Mapper;
import gerenciadorsociety.infrastructure.repositories.LocacaoChurrasqueiraRepository;
import gerenciadorsociety.infrastructure.repositories.entities.locacao.LocacaoChurrasqueiraEntity;
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
    private final Mapper<LocacaoChurrasqueira, LocacaoChurrasqueiraEntity> mapper;

    @Override
    public LocacaoChurrasqueira salvar(LocacaoChurrasqueira locacaoChurrasqueira) {
        LocacaoChurrasqueiraEntity locacao = mapper.paraEntity(locacaoChurrasqueira);
        try {
            locacao = repository.save(locacao);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new SalvarLocacaoChurrasqueiraException(ex.getMessage());
        }

        return mapper.paraDomain(locacao);
    }

    @Override
    public Optional<LocacaoChurrasqueira> buscarLocacaoParaValidacao(LocalTime horaLocacao, LocalDate dataLocacao, Integer numeroChurrasqueira) {
        Optional<LocacaoChurrasqueiraEntity> locacao;
        try {
            locacao = repository.findByLocacaoValidacao(horaLocacao, dataLocacao, numeroChurrasqueira);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new BuscarLocacaoChurrasqueiraValidacaoException(ex.getMessage());
        }
        return locacao.map(mapper::paraDomain);
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DeletarLocacaoChurrasqueiraException(ex.getMessage());
        }
    }

    @Override
    public List<LocacaoChurrasqueira> consultarTodasPorAdminsitrador(Long idAdministrador) {
        List<LocacaoChurrasqueiraEntity> locacoes;
        try {
            locacoes = repository.consultarPorAdministrador(idAdministrador);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new ConsultarLocacaoesChurrasqueiraPorAdministradorException(ex.getMessage());
        }

        return mapper.paraDomains(locacoes);
    }

    @Override
    public Optional<LocacaoChurrasqueira> buscarPorId(Long id) {
        Optional<LocacaoChurrasqueiraEntity> locacao;
        try {
            locacao = repository.findById(id);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new BuscarPorIdLocacaoChurrasqueiraException(ex.getMessage());
        }
        return locacao.map(mapper::paraDomain);
    }
}
