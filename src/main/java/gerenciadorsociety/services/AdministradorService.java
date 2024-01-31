package gerenciadorsociety.services;

import gerenciadorsociety.domains.Administrador;
import gerenciadorsociety.dtos.AdministradorDto;
import gerenciadorsociety.infra.dataprovider.AdministradorDataProvider;
import gerenciadorsociety.infra.mappers.AdministradorMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdministradorService {

    private final AdministradorDataProvider dataProvider;

    private static final String MENSAGEM_ADM_EXISTE = "Admnistrador já está cadastrado";

    public AdministradorDto cadastrar(AdministradorDto dto) {
        Administrador adm = AdministradorMapper.paraDomainDeDto(dto);
        Optional<Administrador> admOptional = dataProvider.consultar(adm.getCpf());
        admOptional.ifPresent(administrador -> {
            throw new RuntimeException(MENSAGEM_ADM_EXISTE);
        });

        return AdministradorMapper.paraDtoDeDomain(dataProvider.salvar(adm));
    }
}
