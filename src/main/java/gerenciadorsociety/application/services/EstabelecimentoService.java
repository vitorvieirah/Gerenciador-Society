package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.EstabelecimentoGateway;
import gerenciadorsociety.application.mappers.Mapper;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstabelecimentoService {

    private final EstabelecimentoGateway gateway;
    private final DonoService donoService;
    private final Mapper<Estabelecimento, EstabelecimentoDto> mapper;

    public EstabelecimentoDto cadastrar(EstabelecimentoDto dto) {
        Optional<Estabelecimento> estabelecimentotoExistente = gateway.consultarPorCnpj(dto.cnpj());

        estabelecimentotoExistente.ifPresent(estabelecimento -> {
            throw new UseCaseException("Estabelecimenot já cadastrado");
        });

        Estabelecimento estabelecimento = mapper.paraDomainDeDto(dto);
        Dono dono = donoService.buscarPorCpf(estabelecimento.getDono().getCpf());
        estabelecimento.setDono(dono);
        return mapper.paraDtoDeDomain(gateway.salvar(estabelecimento));
    }

    public List<EstabelecimentoDto> getEstabelecimentos() {
        return mapper.paraDtosDeDomains(gateway.consultarTodos());
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
        return mapper.paraDtoDeDomain(gateway.salvar(estabelecimentoExistente));
    }
}
