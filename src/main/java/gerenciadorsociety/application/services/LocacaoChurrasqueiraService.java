package gerenciadorsociety.application.services;

import gerenciadorsociety.application.validacoes.Validacoes;
import gerenciadorsociety.domain.locacao.LocacaoChurrasqueira;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoChurrasqueiraDto;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoDto;
import gerenciadorsociety.infrastructure.dataprovider.LocacaoChurrasqueiraDataProvider;
import gerenciadorsociety.infrastructure.mappers.LocacaoChurrasqueiraMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocacaoChurrasqueiraService {

    private final LocacaoChurrasqueiraDataProvider dataProvider;
    private final ChurrasqueiraService churrasqueiraService;
    private final AdministradorService administradorService;
    private final Validacoes<LocacaoChurrasqueira> validacoes;

    public LocacaoDto locar(LocacaoChurrasqueiraDto dto) {
        LocacaoChurrasqueira locacao = LocacaoChurrasqueiraMapper.paraDomainDeDto(dto);
        Optional<LocacaoChurrasqueira> locacaoChurrasqueira = dataProvider.buscarLocacaoParaValidacao(locacao.getHoraLocacao(), locacao.getDataLocacao(), locacao.getChurrasqueira().getNumero());
        validacoes.validacaoObjetoPresente(locacaoChurrasqueira, "Locacao ja existe");

        locacao.setChurrasqueira(churrasqueiraService.buscarPorNumero(locacao.getChurrasqueira().getNumero()));

        locacao.setEstabelecimento(locacao.getChurrasqueira().getEstabelecimento());

        locacao.setAdministrador(administradorService.consultar(locacao.getAdministrador().getCpf()));

        locacao.setData(LocalDate.now());

        return LocacaoChurrasqueiraMapper.paraDtoDeDomain(dataProvider.salvar(locacao));
    }

    public List<LocacaoChurrasqueiraDto> buscarPorTodos() {
        return LocacaoChurrasqueiraMapper.paraDtosDeDomains(dataProvider.consultarTodos());
    }

    public void deletar(Long id) {
        if (dataProvider.buscarPorId(id).isPresent())
            dataProvider.deletar(id);
        else
            throw new RuntimeException("Locação churrasqueira não encontrada para deleção");
    }
}
