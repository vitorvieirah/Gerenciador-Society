package gerenciadorsociety.application.services;

import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import gerenciadorsociety.infrastructure.dataprovider.EstabelecimentoDataProvider;
import gerenciadorsociety.infrastructure.mappers.EstabelecimentoMapper;
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
        Optional<Estabelecimento> estabelecimento = dataProvider.consultarPorCnpj(dto.cnpj());
        validacoes.validacaoObjetoPresente(estabelecimento, "Estabelecimento ja cadastrado");
        Estabelecimento estab = EstabelecimentoMapper.paraDomainDeDto(dto);
        Dono dono = donoService.buscarPorCpf(estab.getDono().getCpf());
        estab.setDono(dono);
        return EstabelecimentoMapper.paraDtoDeDomain(dataProvider.salvar(estab));
    }

    public List<EstabelecimentoDto> getEstabelecimentos() {
        return EstabelecimentoMapper.paraDtosDeDomains(dataProvider.consultarTodos());
    }

    public void deletar(Long id) {
        dataProvider.deletar(id);
    }

    public Estabelecimento consultarPorCnpj(String cnpj) {
        Optional<Estabelecimento> estabelecimentoOptional = dataProvider.consultarPorCnpj(cnpj);
        validacoes.validacaoObjetoVazio(estabelecimentoOptional, "Estabelecimento não encontrado");
        return estabelecimentoOptional.get();
    }
}
