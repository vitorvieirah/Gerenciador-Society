package gerenciadorsociety.services;

import gerenciadorsociety.domains.Dono;
import gerenciadorsociety.domains.Estabelecimento;
import gerenciadorsociety.dtos.EstabelecimentoDto;
import gerenciadorsociety.infra.dataprovider.DonoDataProvider;
import gerenciadorsociety.infra.dataprovider.EstabelecimentoDataProvider;
import gerenciadorsociety.infra.entitys.DonoEntity;
import gerenciadorsociety.infra.entitys.EstabelecimentoEntity;
import gerenciadorsociety.infra.mappers.EstabelecimentoMapper;
import gerenciadorsociety.infra.repositorys.DonoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoDataProvider dataProvider;
    private final DonoService donoService;

    public EstabelecimentoDto cadastrar(EstabelecimentoDto dto) {
        validaEstabelecimentoExistente(dto.cnpj());
        Estabelecimento estab = EstabelecimentoMapper.paraDomainDeDto(dto);
        Dono dono = donoService.buscarPorCpf(estab.getDono().getCpf());
        estab.setDono(dono);
        return EstabelecimentoMapper.paraDtoDeDomain(dataProvider.salvar(estab));
    }

    private void validaEstabelecimentoExistente(String cnpj){
        Optional<Estabelecimento> estabelecimento = consultarPorCnpj(cnpj);
        estabelecimento.ifPresent(estb -> {
            throw new RuntimeException("Estabelecimento ja cadastrado");
        });
    }

    public List<EstabelecimentoDto> getEstabelecimentos() {
        return EstabelecimentoMapper.paraDtosDeDomains(dataProvider.consultarTodos());
    }

    public void deletar (Long id){
        dataProvider.deletar(id);
    }

    public Optional<Estabelecimento> consultarPorCnpj(String cnpj) {
        return dataProvider.consultarPorCnpj(cnpj);
    }
}
