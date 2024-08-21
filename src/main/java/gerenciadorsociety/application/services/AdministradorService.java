package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.AdministradorGateway;
import gerenciadorsociety.application.mappers.Mapper;
import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
import gerenciadorsociety.infrastructure.mappers.AdministradorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdministradorService {

    private final AdministradorGateway administradorGateway;
    private final Mapper<Administrador, AdministradorDto> mapper;

    private static final String MENSAGEM_ADMINISTRADOR_EXISTE = "Admnistrador já está cadastrado";
    private static final String MENSAGEM_ADMINSITRADOR_NAO_ENCONTRADO = "Administrador não encontrado";

    public AdministradorDto cadastrar(AdministradorDto administradorDto) {
        Administrador administrador = mapper.paraDomainDeDto(administradorDto);
        Optional<Administrador> administradorExistente = administradorGateway.consultarPorCpf(administrador.getCpf());
        administradorExistente.ifPresent(adm -> {
            throw new UseCaseException(MENSAGEM_ADMINISTRADOR_EXISTE);
        });
        return mapper.paraDtoDeDomain(administradorGateway.salvar(administrador));
    }

    public AdministradorDto consultarPorId(Long id) {
        Optional<Administrador> resultQuery = administradorGateway.consultarPorId(id);
        if (resultQuery.isEmpty())
            throw new UseCaseException(MENSAGEM_ADMINSITRADOR_NAO_ENCONTRADO);
        return mapper.paraDtoDeDomain(resultQuery.get());
    }

    public AdministradorDto alterar(AdministradorDto administradorDto, Long id) {
        Administrador administradorExistente = mapper.paraDomainDeDto(consultarPorId(id));
        administradorExistente.setInformacoes(administradorDto);

        return mapper.paraDtoDeDomain(administradorGateway.salvar(administradorExistente));
    }

    public void deletar(Long id) {
        consultarPorId(id);
        administradorGateway.deletar(id);
    }
}
