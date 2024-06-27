package gerenciadorsociety.services;

import gerenciadorsociety.domains.Administrador;
import gerenciadorsociety.domains.Churrasqueira;
import gerenciadorsociety.domains.Estabelecimento;
import gerenciadorsociety.domains.LocacaoChurrasqueira;
import gerenciadorsociety.dtos.AdministradorDto;
import gerenciadorsociety.dtos.LocacaoChurrasqueiraDto;
import gerenciadorsociety.dtos.LocacaoDto;
import gerenciadorsociety.infra.dataprovider.AdministradorDataProvider;
import gerenciadorsociety.infra.dataprovider.ChurrasqueiraDataProvider;
import gerenciadorsociety.infra.dataprovider.EstabelecimentoDataProvider;
import gerenciadorsociety.infra.dataprovider.LocacaoChurrasqueiraDataProvider;
import gerenciadorsociety.infra.mappers.LocacaoChurrasqueiraMapper;
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

    public LocacaoDto locar(LocacaoChurrasqueiraDto dto) {
        LocacaoChurrasqueira locacao = LocacaoChurrasqueiraMapper.paraDomainDeDto(dto);
        Optional<LocacaoChurrasqueira> locacaoChurrasqueira = dataProvider.buscarLocacaoParaValidacao(locacao.getHoraLocacao(), locacao.getDataLocacao(), locacao.getChurrasqueira().getNumero());
        locacaoChurrasqueira.ifPresent(loc -> {
            throw new RuntimeException("Locacao ja existe");
        });

        Optional<Churrasqueira> churrasqueiraOptional = churrasqueiraService.buscarPorNumero(locacao.getChurrasqueira().getNumero());

        if(churrasqueiraOptional.isPresent())
            locacao.setChurrasqueira(churrasqueiraOptional.get());
        else
            throw new RuntimeException("Churrasqueira não encontrada");

        locacao.setEstabelecimento(locacao.getChurrasqueira().getEstabelecimento());

        Optional<Administrador> administrador = administradorService.consultar(locacao.getAdministrador().getCpf());

        if(administrador.isPresent())
            locacao.setAdministrador(administrador.get());
        else
            throw new RuntimeException("Administrador não encontrado");

        locacao.setData(LocalDate.now());

        return LocacaoChurrasqueiraMapper.paraDtoDeDomain(dataProvider.salvar(locacao));
    }

    public List<LocacaoChurrasqueiraDto> buscarPorTodos() {
        return LocacaoChurrasqueiraMapper.paraDtosDeDomains(dataProvider.getAll());
    }

    public void deletar(Long id) {
        dataProvider.deletar(id);
    }
}
