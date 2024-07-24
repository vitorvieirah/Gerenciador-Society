package gerenciadorsociety.application.services;

import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.infrastructure.dataprovider.CampoDataProvider;
import gerenciadorsociety.infrastructure.mappers.CampoMapper;
import gerenciadorsociety.application.validacoes.Validacoes;
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
        validacoesCampo.validacaoObjetoPresente(campoOptional, "Campo ja esta cadastrado");

        Campo campo = CampoMapper.paraDomainDeDto(dto);

        campo.setEstabelecimento(estabelecimentoService.consultarPorCnpj(dto.estabelecimento().cnpj()));

        return CampoMapper.paraDtoDeDomain(dataProvider.salvar(campo));
    }

    public Campo buscarPorNumero(Integer numero) {
        Optional<Campo> campoOptional = dataProvider.buscarPorNumero(numero);
        validacoesCampo.validacaoObjetoVazio(campoOptional, "Campo não encontrado");
        return campoOptional.get();
    }
}
