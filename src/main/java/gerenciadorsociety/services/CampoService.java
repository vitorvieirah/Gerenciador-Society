package gerenciadorsociety.services;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.domains.Estabelecimento;
import gerenciadorsociety.dtos.CampoDto;
import gerenciadorsociety.dtos.EstabelecimentoDto;
import gerenciadorsociety.infra.dataprovider.CampoDataProvider;
import gerenciadorsociety.infra.dataprovider.EstabelecimentoDataProvider;
import gerenciadorsociety.infra.mappers.CampoMapper;
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

    public CampoDto cadastrar(CampoDto dto) {
        Optional<Campo> campoOptional = dataProvider.buscarPorNumero(dto.numero());
        campoOptional.ifPresent(cmp -> {
            throw new RuntimeException("Campo ja esta cadastrado");
        });
        Campo campo = CampoMapper.paraDomainDeDto(dto);
        Optional<Estabelecimento> estabelecimento = estabelecimentoService.consultarPorCnpj(dto.estabelecimento().cnpj());

        if(estabelecimento.isEmpty())
            throw new RuntimeException("Estabelecimento não encotrado");

        campo.setEstabelecimento(estabelecimento.get());

        return CampoMapper.paraDtoDeDomain(dataProvider.salvar(campo));
    }

    public Optional<Campo> buscarPorNumero(Integer numero) {
        return dataProvider.buscarPorNumero(numero);
    }
}
