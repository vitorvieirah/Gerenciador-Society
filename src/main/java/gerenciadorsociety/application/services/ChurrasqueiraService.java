package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.ChurrasqueiraGateway;
import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import gerenciadorsociety.infrastructure.dataprovider.ChurrasqueiraDataProvider;
import gerenciadorsociety.infrastructure.mappers.ChurrasqueiraMapper;
import gerenciadorsociety.infrastructure.repositories.entities.ChurrasqueiraEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChurrasqueiraService {

    private final ChurrasqueiraGateway gateway;
    private final EstabelecimentoService estabelecimentoService;

    public ChurrasqueiraDto cadastrar(ChurrasqueiraDto dto) {
        Optional<Churrasqueira> churrasqueiraOptional = gateway.buscarPorNumero(dto.numero());

        churrasqueiraOptional.ifPresent(churrasqueira -> {
            throw new UseCaseException("Churrasqueira já cadastrada");
        });

        Churrasqueira churrasqueira = ChurrasqueiraMapper.paraDomainDeDto(dto);

        churrasqueira.setEstabelecimento(estabelecimentoService.consultarPorCnpj(dto.estabelecimento().cnpj()));

        return ChurrasqueiraMapper.paraDtoDeDomain(gateway.salvar(churrasqueira));
    }

    public ChurrasqueiraDto alterar(Long id, ChurrasqueiraDto dto){
        var churasqueira = buscarPorId(id);
        churasqueira.atualizarInformacoes(dto);
        return ChurrasqueiraMapper.paraDtoDeDomain(gateway.salvar(churasqueira));
    }

    public Churrasqueira buscarPorNumero(Integer numero) {
        Optional<Churrasqueira> churrasqueiraOptional = gateway.buscarPorNumero(numero);
        if(churrasqueiraOptional.isEmpty())
            throw new UseCaseException("Churrasqueira não econtrada");
        return churrasqueiraOptional.get();
    }

    public void deletar(Long id){
        gateway.deletar(id);
    }

    public List<ChurrasqueiraDto> buscarPorEstabelecimento(Long idEstabelecimento) {
        return gateway.buscarPorEstabelecimento(idEstabelecimento).stream().map(ChurrasqueiraMapper::paraDtoDeDomain).toList();
    }

    public Churrasqueira buscarPorId(Long id) {
        Optional<Churrasqueira> churrasqueira = gateway.buscarPorId(id);

        if(churrasqueira.isEmpty())
            throw new UseCaseException("Churrasqueira não econtrada");

        return churrasqueira.get();
    }
}
