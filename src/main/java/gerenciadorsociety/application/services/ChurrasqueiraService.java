package gerenciadorsociety.application.services;

import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import gerenciadorsociety.infrastructure.dataprovider.ChurrasqueiraDataProvider;
import gerenciadorsociety.infrastructure.mappers.ChurrasqueiraMapper;
import gerenciadorsociety.application.validacoes.Validacoes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ChurrasqueiraService {

    private final ChurrasqueiraDataProvider dataProvider;
    private final EstabelecimentoService estabelecimentoService;
    private final Validacoes<Churrasqueira> validacoesChurrasqueira;

    public ChurrasqueiraDto cadastrar(ChurrasqueiraDto dto) {
        Optional<Churrasqueira> churrasqueiraOptional = dataProvider.buscarPorNumero(dto.numero());
        validacoesChurrasqueira.validacaoObjetoPresente(churrasqueiraOptional, "Churrasqueira ja cadastrada");

        Churrasqueira churrasqueira = ChurrasqueiraMapper.paraDomainDeDto(dto);

        churrasqueira.setEstabelecimento(estabelecimentoService.consultarPorCnpj(dto.estabelecimento().cnpj()));

        return ChurrasqueiraMapper.paraDtoDeDomain(dataProvider.salvar(churrasqueira));
    }

    public Churrasqueira buscarPorNumero(Integer numero) {
        Optional<Churrasqueira> churrasqueiraOptional = dataProvider.buscarPorNumero(numero);
        validacoesChurrasqueira.validacaoObjetoVazio(churrasqueiraOptional, "Churrasqueira não encontrada");
        return churrasqueiraOptional.get();
    }
}
