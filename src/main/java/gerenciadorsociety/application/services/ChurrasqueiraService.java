package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.ChurrasqueiraGateway;
import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import gerenciadorsociety.infrastructure.dataprovider.ChurrasqueiraDataProvider;
import gerenciadorsociety.infrastructure.mappers.ChurrasqueiraMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public ChurrasqueiraDto alterar(Integer numero, ChurrasqueiraDto dto){
        var churasqueira = buscarPorNumero(numero);
        churasqueira.atualizarInformacoes(dto);
        return ChurrasqueiraMapper.paraDtoDeDomain(gateway.salvar(churasqueira));
    }

    public Churrasqueira buscarPorNumero(Integer numero) {
        Optional<Churrasqueira> churrasqueiraOptional = gateway.buscarPorNumero(numero);
        if(churrasqueiraOptional.isEmpty())
            throw new UseCaseException("Churrasqueira não econtrada");
        return churrasqueiraOptional.get();
    }

    public void deletar(int numero){
        var churrasqueiraExistente = buscarPorNumero(numero);
        gateway.deletar(churrasqueiraExistente.getId());
    }
}
