package gerenciadorsociety.services;

import gerenciadorsociety.domains.Administrador;
import gerenciadorsociety.dtos.AdministradorDto;
import gerenciadorsociety.infra.dataprovider.AdministradorDataProvider;
import gerenciadorsociety.infra.mappers.AdministradorMapper;
import gerenciadorsociety.services.validacoes.Validacoes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdministradorService {

    private final AdministradorDataProvider dataProvider;
    private final Validacoes<Administrador> validacoes;

    private static final String MENSAGEM_ADM_EXISTE = "Admnistrador já está cadastrado";

    public AdministradorDto cadastrar(AdministradorDto dto) {
        Administrador adm = AdministradorMapper.paraDomainDeDto(dto);
        Optional<Administrador> admOptional = dataProvider.consultar(adm.getCpf());
        validacoes.validacaoObjetoPresente(admOptional, MENSAGEM_ADM_EXISTE);
        return AdministradorMapper.paraDtoDeDomain(dataProvider.salvar(adm));
    }

    public Administrador consultar(String cpf) {
        Optional<Administrador> administradorOptional = dataProvider.consultar(cpf);
        validacoes.validacaoObjetoVazio(administradorOptional, "Administrador não encontrado");
        return administradorOptional.get();
    }
}
