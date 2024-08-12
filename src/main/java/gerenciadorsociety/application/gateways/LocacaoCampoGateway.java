package gerenciadorsociety.application.gateways;

import gerenciadorsociety.domain.locacao.LocacaoCampo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface LocacaoCampoGateway {
    LocacaoCampo salvar(LocacaoCampo locacaoCampo);
    Optional<LocacaoCampo> buscarPorId(Long id);
    List<LocacaoCampo> consultarTodasLocacoesPorAdministrador(Long idAministrador);
    void deletar(Long id);
    Optional<LocacaoCampo> buscarPorHoraLocacao(LocalTime horaLocacao, LocalDate dataLocacao, Integer numero);
}
