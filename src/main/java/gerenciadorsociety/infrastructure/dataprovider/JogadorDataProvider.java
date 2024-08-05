package gerenciadorsociety.infrastructure.dataprovider;

import gerenciadorsociety.application.gateways.JogadorGateway;
import gerenciadorsociety.domain.usuarios.Jogador;
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

        try{
            jogadorEntity = repository.save();
        }

        return null;
    }

    @Override
    public Optional<Jogador> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public void deletar(Long id) {

    }
}
