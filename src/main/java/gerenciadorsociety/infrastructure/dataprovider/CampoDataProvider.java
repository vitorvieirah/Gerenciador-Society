package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.infrastructure.repositories.entities.CampoEntity;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.DataProviderExecption;
import gerenciadorsociety.infrastructure.mappers.CampoMapper;
import gerenciadorsociety.infrastructure.repositories.CampoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class CampoDataProvider {

    private final CampoRepository repository;

    public Campo salvar(Campo campo) {
        CampoEntity campoEntity = CampoMapper.paraEntityDeDomain(campo);
        try {
            campoEntity = repository.save(campoEntity);
        } catch (Exception ex) {
            log.error("Erro ao salvar Campo", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
        return CampoMapper.paraDomainDeEntity(campoEntity);
    }

    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar campo", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

    public Optional<Campo> buscarPorNumero(Integer numero) {
        Optional<CampoEntity> campoEntity;
        try {
            campoEntity = repository.findByNumero(numero);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DataProviderExecption(ex.getMessage());
        }

        return campoEntity.map(CampoMapper::paraDomainDeEntity);
    }
}
