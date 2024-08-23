package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.gateways.CampoGateway;
import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.DataProviderExecption;
import gerenciadorsociety.infrastructure.mappers.Mapper;
import gerenciadorsociety.infrastructure.repositories.CampoRepository;
import gerenciadorsociety.infrastructure.repositories.entities.CampoEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class CampoDataProvider implements CampoGateway {

    private final CampoRepository repository;
    private final Mapper<Campo, CampoEntity> mapper;

    @Override
    public Campo salvar(Campo campo) {
        CampoEntity campoEntity = mapper.paraEntity(campo);
        try {
            campoEntity = repository.save(campoEntity);
        } catch (Exception ex) {
            log.error("Erro ao salvar Campo", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return mapper.paraDomain(campoEntity);
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar campo", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

    @Override
    public List<Campo> buscarPorEstabelecimento(Long idEstabelecimento) {
        List<CampoEntity> campoEntities;

        try{
            campoEntities = repository.buscarPorEstabelecimento(idEstabelecimento);
        }catch (Exception ex){
            log.error("Erro ao buscar campos por estabelecimentos", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return mapper.paraDomains(campoEntities);
    }

    @Override
    public Optional<Campo> buscarPorId(Long idCampo) {
        try {
            return repository.findById(idCampo).map(mapper::paraDomain);
        }catch (Exception ex){
            log.error("Erro ao buscar campo por id", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

    @Override
    public Optional<Campo> buscarPorNumero(int numero) {
        Optional<CampoEntity> campoEntity;
        try {
            campoEntity = repository.findByNumero(numero);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }

        return campoEntity.map(mapper::paraDomain);
    }
}
