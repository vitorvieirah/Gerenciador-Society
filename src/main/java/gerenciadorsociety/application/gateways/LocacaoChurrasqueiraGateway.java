package gerenciadorsociety.application.gateways;

import gerenciadorsociety.domain.locacao.LocacaoChurrasqueira;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface LocacaoChurrasqueiraGateway {

    LocacaoChurrasqueira salvar(LocacaoChurrasqueira locacaoChurrasqueira);
    List<LocacaoChurrasqueira> consultarTodasPorAdminsitrador(Long idAdministrador);
    void deletar(Long id);
    Optional<LocacaoChurrasqueira> buscarPorId(Long id);
    Optional<LocacaoChurrasqueira> buscarLocacaoParaValidacao(LocalTime horaLocacao, LocalDate dataLocacao, Integer numeroChurrasqueira);
}
