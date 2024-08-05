package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.EstabelecimentoGateway;
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

    private final EstabelecimentoGateway gateway;
    private final DonoService donoService;

    public EstabelecimentoDto cadastrar(EstabelecimentoDto dto) {
        Optional<Estabelecimento> estabelecimentotoExistente = gateway.consultarPorCnpj(dto.cnpj());

        estabelecimentotoExistente.ifPresent(estabelecimento -> {
            throw new UseCaseException("Estabelecimenot já cadastrado");
        });

        Estabelecimento estabelecimento = EstabelecimentoMapper.paraDomainDeDto(dto);
        Dono dono = donoService.buscarPorCpf(estabelecimento.getDono().getCpf());
        estabelecimento.setDono(dono);
        return EstabelecimentoMapper.paraDtoDeDomain(gateway.salvar(estabelecimento));
    }

    public List<EstabelecimentoDto> getEstabelecimentos() {
        return EstabelecimentoMapper.paraDtosDeDomains(gateway.consultarTodos());
    }

    public void deletar(Long id) {
        gateway.deletar(id);
    }

    public Estabelecimento consultarPorCnpj(String cnpj) {
        Optional<Estabelecimento> estabelecimentoExistente = gateway.consultarPorCnpj(cnpj);
        if (estabelecimentoExistente.isEmpty())
            throw new UseCaseException("Estabelecimento não encontrado");
        return estabelecimentoExistente.get();
    }

    public Estabelecimento buscarPorId(Long id) {
        Optional<Estabelecimento> estabelecimento = gateway.consultarPorId(id);
        if (estabelecimento.isEmpty())
            throw new UseCaseException("Estabelecimento não econtrado");
        return estabelecimento.get();
    }

    public EstabelecimentoDto alterar(EstabelecimentoDto novosDados, Long id) {
        Estabelecimento estabelecimentoExistente = buscarPorId(id);
        estabelecimentoExistente.alterarInformacoes(novosDados);
        return EstabelecimentoMapper.paraDtoDeDomain(gateway.salvar(estabelecimentoExistente));
    }
}
