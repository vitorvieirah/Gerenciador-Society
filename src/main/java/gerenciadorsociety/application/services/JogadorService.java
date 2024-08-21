package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.JogadorGateway;
import gerenciadorsociety.application.mappers.Mapper;
import gerenciadorsociety.domain.usuarios.Jogador;
import gerenciadorsociety.entrypoint.dtos.usuarios.JogadorDto;
import gerenciadorsociety.infrastructure.mappers.JogadorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class JogadorService {

    private final Mapper<Jogador, JogadorDto> mapper;
    private final JogadorGateway gateway;

    public JogadorDto cadastrar(JogadorDto jogadorDto) {
        Optional<Jogador> jogadorExistente = gateway.buscarPorId(jogadorDto.id());

        jogadorExistente.ifPresent(jogador -> {
            throw new UseCaseException("Jogador já cadastrado");
        });

        return mapper.paraDtoDeDomain(gateway.salvar(mapper.paraDomainDeDto(jogadorDto)));
    }

    public JogadorDto buscarPorId(Long id) {
        Optional<Jogador> jogador = gateway.buscarPorId(id);

        if (jogador.isEmpty())
            throw new UseCaseException("Jogador não encontrado por id");

        return mapper.paraDtoDeDomain(jogador.get());
    }

    public JogadorDto alterar(JogadorDto novosDados, Long id) {
        Jogador jogadorExistente = mapper.paraDomainDeDto(buscarPorId(id));

        jogadorExistente.alterarInformacoes(novosDados);

        return mapper.paraDtoDeDomain(gateway.salvar(jogadorExistente));
    }

    public void deletar(Long id) {
        gateway.deletar(id);
    }
}
