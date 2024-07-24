package gerenciadorsociety.application.services;

import gerenciadorsociety.application.gateways.AdministradorGateway;
import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
import gerenciadorsociety.infrastructure.mappers.AdministradorMapper;
import gerenciadorsociety.application.validacoes.Validacoes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdministradorService {

    private final AdministradorGateway administradorGateway;
    private final Validacoes<Administrador> validacoes;

    private static final String MENSAGEM_ADM_EXISTE = "Admnistrador já está cadastrado";

    public AdministradorDto cadastrar(AdministradorDto administradorDto) {
        Administrador administrador = AdministradorMapper.paraDomainDeDto(administradorDto);
        Optional<Administrador> administradorExistente = administradorGateway.consultar(administrador.getCpf());
        validacoes.validacaoObjetoPresente(administradorExistente, MENSAGEM_ADM_EXISTE);
        return AdministradorMapper.paraDtoDeDomain(administradorGateway.salvar(administrador));
    }

    public Administrador consultar(String cpf) {
        Optional<Administrador> administradorOptional = administradorGateway.consultar(cpf);
        validacoes.validacaoObjetoVazio(administradorOptional, "Administrador não encontrado");
        return administradorOptional.get();
    }
}
