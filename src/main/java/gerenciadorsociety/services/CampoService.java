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
    private final EstabelecimentoDataProvider estabelecimentoDataProvider;

    public CampoDto cadastrar(CampoDto dto) {
        System.out.println(dto);
        Optional<Campo> campoOptional = dataProvider.buscarPorNumero(dto.numero());
        campoOptional.ifPresent(cmp -> {
            throw new RuntimeException("Campo ja esta cadastrado");
        });
        Campo campo = CampoMapper.paraDomainDeDto(dto);
        System.out.println(campo);
        Optional<Estabelecimento> estabelecimento = estabelecimentoDataProvider.consultarPorCnpj(dto.cnpj());

        if(estabelecimento.isPresent())
            campo.setEstabelecimento(estabelecimento.get());
        else
            throw new RuntimeException("Estabelecimento não encotrado");

        System.out.println(campo);

        return CampoMapper.paraDtoDeDomain(dataProvider.salvar(campo));
    }
}
