package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.JogadorGateway;
import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.domain.usuarios.Jogador;
import gerenciadorsociety.entrypoint.dtos.usuarios.JogadorDto;
import gerenciadorsociety.infrastructure.dataprovider.LocacaoCampoDataProvider;
import gerenciadorsociety.infrastructure.mappers.JogadorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JogadorService {

    private final LocacaoCampoService locacaoCampoService;
    private final JogadorGateway gateway;

    public JogadorDto cadastrar(JogadorDto jogadorDto){
        Optional<Jogador> jogadorExistente = gateway.buscarPorId(jogadorDto.id());

        jogadorExistente.ifPresent(jogador -> {
            throw new UseCaseException("Jogador já cadastrado");
        });

        return JogadorMapper.paraDto(gateway.salvar(JogadorMapper.paraDomainDeDto(jogadorDto)));
    }

    public Jogador buscarPorId(Long id){
        Optional<Jogador> jogador = gateway.buscarPorId(id);

        if(jogador.isEmpty())
            throw new UseCaseException("Jogador não encontrado por id");

        return jogador.get();
    }

    public JogadorDto alterar(JogadorDto novosDados, Long id){
        Jogador jogadorExistente = buscarPorId(id);

        jogadorExistente.alterarInformacoes(novosDados);

        return JogadorMapper.paraDto(gateway.salvar(jogadorExistente));
    }

    public void deletar(Long id){
        gateway.deletar(id);
    }
}
