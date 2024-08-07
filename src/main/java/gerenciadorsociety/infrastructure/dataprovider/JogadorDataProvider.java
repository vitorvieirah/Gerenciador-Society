package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.gateways.JogadorGateway;
import gerenciadorsociety.domain.usuarios.Jogador;
import gerenciadorsociety.infrastructure.dataprovider.exceptions.DataProviderExecption;
import gerenciadorsociety.infrastructure.mappers.JogadorMapper;
import gerenciadorsociety.infrastructure.repositories.JogadorRepository;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.JogadorEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class JogadorDataProvider implements JogadorGateway {

    private final JogadorRepository repository;

    @Override
    public Jogador salvar(Jogador jogador) {
        JogadorEntity jogadorEntity = JogadorMapper.paraEntity(jogador);

        try {
            jogadorEntity = repository.save(jogadorEntity);
        } catch (Exception ex) {
            log.error("Erro ao cadastrar jogador", ex);
            throw new DataProviderExecption(ex.getMessage());
        }

        return JogadorMapper.paraDomain(jogadorEntity);
    }

    @Override
    public Optional<Jogador> buscarPorId(Long id) {
        try {
            return repository.findById(id).map(JogadorMapper::paraDomain);
        } catch (Exception ex) {
            log.error("Erro ao buscar jogador por id", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }

    @Override
    public void deletar(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception ex) {
            log.error("Erro ao deletar jogador", ex);
            throw new DataProviderExecption(ex.getMessage());
        }
    }
}
