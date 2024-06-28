package gerenciadorsociety.services;

import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.domains.Estabelecimento;
import gerenciadorsociety.dtos.ChurrasqueiraDto;
import gerenciadorsociety.infra.dataprovider.ChurrasqueiraDataProvider;
import gerenciadorsociety.infra.dataprovider.EstabelecimentoDataProvider;
import gerenciadorsociety.infra.mappers.ChurrasqueiraMapper;
import gerenciadorsociety.services.validacoes.Validacoes;
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
        validacoesChurrasqueira.validacaoCadastro(churrasqueiraOptional, "Churrasqueira ja cadastrada");

        Churrasqueira churrasqueira = ChurrasqueiraMapper.paraDomainDeDto(dto);

        churrasqueira.setEstabelecimento(estabelecimentoService.consultarPorCnpj(dto.estabelecimento().cnpj()));

        return ChurrasqueiraMapper.paraDtoDeDomain(dataProvider.salvar(churrasqueira));
    }

    public Churrasqueira buscarPorNumero(Integer numero) {
        Optional<Churrasqueira> churrasqueiraOptional = dataProvider.buscarPorNumero(numero);
        validacoesChurrasqueira.validacaoObjetoNaoEncontrado(churrasqueiraOptional, "Churrasqueira não encontrada");
        return churrasqueiraOptional.get();
    }
}
