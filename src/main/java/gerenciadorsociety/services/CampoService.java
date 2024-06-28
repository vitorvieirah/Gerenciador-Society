package gerenciadorsociety.services;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.domains.Estabelecimento;
import gerenciadorsociety.dtos.CampoDto;
import gerenciadorsociety.infra.dataprovider.CampoDataProvider;
import gerenciadorsociety.infra.mappers.CampoMapper;
import gerenciadorsociety.services.validacoes.Validacoes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CampoService {

    private final CampoDataProvider dataProvider;
    private final EstabelecimentoService estabelecimentoService;
    private final Validacoes<Campo> validacoesCampo;

    public CampoDto cadastrar(CampoDto dto) {
        Optional<Campo> campoOptional = dataProvider.buscarPorNumero(dto.numero());
        validacoesCampo.validacaoCadastro(campoOptional, "Campo ja esta cadastrado");

        Campo campo = CampoMapper.paraDomainDeDto(dto);

        campo.setEstabelecimento(estabelecimentoService.consultarPorCnpj(dto.estabelecimento().cnpj()));

        return CampoMapper.paraDtoDeDomain(dataProvider.salvar(campo));
    }

    public Campo buscarPorNumero(Integer numero) {
        Optional<Campo> campoOptional = dataProvider.buscarPorNumero(numero);
        validacoesCampo.validacaoObjetoNaoEncontrado(campoOptional, "Campo não encontrado");
        return campoOptional.get();
    }
}
