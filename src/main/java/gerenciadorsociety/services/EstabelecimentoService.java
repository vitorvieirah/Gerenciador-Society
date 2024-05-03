package gerenciadorsociety.services;

import gerenciadorsociety.domains.Dono;
import gerenciadorsociety.domains.Estabelecimento;
import gerenciadorsociety.dtos.EstabelecimentoDto;
import gerenciadorsociety.infra.dataprovider.DonoDataProvider;
import gerenciadorsociety.infra.dataprovider.EstabelecimentoDataProvider;
import gerenciadorsociety.infra.mappers.EstabelecimentoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoDataProvider dataProvider;
    private final DonoDataProvider donoDataProvider;

    public EstabelecimentoDto cadastrar(EstabelecimentoDto dto) {
        validaVendaExistente(dto.cnpj());
        Estabelecimento estab = EstabelecimentoMapper.paraDomainDeDto(dto);
        defineDonoEstabalecimento(estab);
        return EstabelecimentoMapper.paraDtoDeDomain(dataProvider.salvar(estab));
    }

    private void validaVendaExistente(String cnpj){
        Optional<Estabelecimento> estabelecimento = dataProvider.consultarPorCnpj(cnpj);
        estabelecimento.ifPresent(estb -> {
            throw new RuntimeException("Estabelecimento ja cadastrado");
        });
    }

    private void defineDonoEstabalecimento(Estabelecimento estabelecimento){
        Optional<Dono> donoOptional = donoDataProvider.consultarPorCpf(estabelecimento.getCpfDono());

        if(donoOptional.isPresent()){
            estabelecimento.setDono(donoOptional.get());
        }else {
            throw new RuntimeException("Dono não encontrado");
        }
    }

    public List<EstabelecimentoDto> getEstabelecimentos() {
        return EstabelecimentoMapper.paraDtosDeDomains(dataProvider.consultarTodos());
    }

    public void deletar (String cnpj){
        dataProvider.deletar(cnpj);
    }

}
