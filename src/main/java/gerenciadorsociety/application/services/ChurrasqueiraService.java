package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.ChurrasqueiraGateway;
import gerenciadorsociety.application.mappers.Mapper;
import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChurrasqueiraService {

    private final ChurrasqueiraGateway gateway;
    private final EstabelecimentoService estabelecimentoService;
    private final Mapper<Churrasqueira, ChurrasqueiraDto> mapper;

    public ChurrasqueiraDto cadastrar(ChurrasqueiraDto dto) {
        Optional<Churrasqueira> churrasqueiraOptional = gateway.buscarPorNumero(dto.numero());

        churrasqueiraOptional.ifPresent(churrasqueira -> {
            throw new UseCaseException("Churrasqueira já cadastrada");
        });

        Churrasqueira churrasqueira = mapper.paraDomainDeDto(dto);

        churrasqueira.setEstabelecimento(estabelecimentoService.consultarPorCnpj(dto.estabelecimento().cnpj()));

        return mapper.paraDtoDeDomain(gateway.salvar(churrasqueira));
    }

    public ChurrasqueiraDto alterar(Long id, ChurrasqueiraDto dto) {
        var churasqueira = buscarPorId(id);
        churasqueira.atualizarInformacoes(dto);
        return mapper.paraDtoDeDomain(gateway.salvar(churasqueira));
    }

    public Churrasqueira buscarPorNumero(Integer numero) {
        Optional<Churrasqueira> churrasqueiraOptional = gateway.buscarPorNumero(numero);
        if (churrasqueiraOptional.isEmpty())
            throw new UseCaseException("Churrasqueira não econtrada");
        return churrasqueiraOptional.get();
    }

    public void deletar(Long id) {
        gateway.deletar(id);
    }

    public List<ChurrasqueiraDto> buscarPorEstabelecimento(Long idEstabelecimento) {
        return gateway.buscarPorEstabelecimento(idEstabelecimento).stream().map(mapper::paraDtoDeDomain).toList();
    }

    public Churrasqueira buscarPorId(Long id) {
        Optional<Churrasqueira> churrasqueira = gateway.buscarPorId(id);

        if (churrasqueira.isEmpty())
            throw new UseCaseException("Churrasqueira não econtrada");

        return churrasqueira.get();
    }
}
