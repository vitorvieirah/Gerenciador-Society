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
import gerenciadorsociety.services.validacoes.Validacoes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoDataProvider dataProvider;
    private final DonoService donoService;
    private final Validacoes<Estabelecimento> validacoes;

    public EstabelecimentoDto cadastrar(EstabelecimentoDto dto) {
        Optional<Estabelecimento> estabelecimento = dataProvider.consultarPorCnpj(dto.cnpj());
        validacoes.validacaoCadastro(estabelecimento, "Estabelecimento ja cadastrado");
        Estabelecimento estab = EstabelecimentoMapper.paraDomainDeDto(dto);
        Dono dono = donoService.buscarPorCpf(estab.getDono().getCpf());
        estab.setDono(dono);
        return EstabelecimentoMapper.paraDtoDeDomain(dataProvider.salvar(estab));
    }

    public List<EstabelecimentoDto> getEstabelecimentos() {
        return EstabelecimentoMapper.paraDtosDeDomains(dataProvider.consultarTodos());
    }

    public void deletar (Long id){
        dataProvider.deletar(id);
    }

    public Estabelecimento consultarPorCnpj(String cnpj) {
        Optional<Estabelecimento> estabelecimentoOptional = dataProvider.consultarPorCnpj(cnpj);
        validacoes.validacaoObjetoNaoEncontrado(estabelecimentoOptional, "Estabelecimento não encontrado");
        return estabelecimentoOptional.get();
    }
}
