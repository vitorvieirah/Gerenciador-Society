package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.LocacaoChurrasqueiraGateway;
import gerenciadorsociety.application.mappers.Mapper;
import gerenciadorsociety.domain.locacao.LocacaoChurrasqueira;
import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoChurrasqueiraDto;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoDto;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocacaoChurrasqueiraService {

    private final LocacaoChurrasqueiraGateway gateway;
    private final ChurrasqueiraService churrasqueiraService;
    private final AdministradorService administradorService;
    private final Mapper<LocacaoChurrasqueira, LocacaoChurrasqueiraDto> mapper;
    private final Mapper<Administrador, AdministradorDto> administradorMapper;

    public LocacaoDto locar(LocacaoChurrasqueiraDto dto) {
        LocacaoChurrasqueira locacao = mapper.paraDomainDeDto(dto);
        Optional<LocacaoChurrasqueira> locacaoExistente = gateway.buscarLocacaoParaValidacao(locacao.getHoraLocacao(), locacao.getDataLocacao(), locacao.getChurrasqueira().getNumero());

        locacaoExistente.ifPresent(locacaoChurrasqueira ->{
            throw new UseCaseException("Locação já cadastrada");
        });

        locacao.setChurrasqueira(churrasqueiraService.buscarPorNumero(locacao.getChurrasqueira().getNumero()));

        locacao.setEstabelecimento(locacao.getChurrasqueira().getEstabelecimento());

        locacao.setAdministrador(administradorMapper.paraDomainDeDto(administradorService.consultarPorId(locacao.getAdministrador().getId())));

        locacao.setData(LocalDate.now());

        return mapper.paraDtoDeDomain(gateway.salvar(locacao));
    }

    public List<LocacaoChurrasqueiraDto> buscarPorTodos(Long idAdministrador) {
        return mapper.paraDtosDeDomains(gateway.consultarTodasPorAdminsitrador(idAdministrador));
    }

    public void deletar(Long id) {
        LocacaoChurrasqueira locacao = buscarPorId(id);
        gateway.deletar(locacao.getId());
    }

    public LocacaoChurrasqueira buscarPorId(Long id){
        Optional<LocacaoChurrasqueira> locacaoChurrasqueira = gateway.buscarPorId(id);

        if(locacaoChurrasqueira.isEmpty())
            throw new UseCaseException("Locacão churrasqueira não encontrada");

        return locacaoChurrasqueira.get();
    }
}
