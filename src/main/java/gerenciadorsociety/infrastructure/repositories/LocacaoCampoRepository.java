package gerenciadorsociety.infrastructure.repositories;

import gerenciadorsociety.infrastructure.repositories.entities.locacao.LocacaoCampoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface LocacaoCampoRepository extends JpaRepository<LocacaoCampoEntity, Long> {

    @Query("SELECT lc " +
            "FROM LocacaoCampo lc " +
            "WHERE lc.horaLocacao = :horaLocacao AND " +
            "lc.dataLocacao = :dataLocacao AND " +
            "lc.campo.numero = :numeroCampo")
    Optional<LocacaoCampoEntity> findLocacaoValidacao(LocalTime horaLocacao, LocalDate dataLocacao, Integer numeroCampo);

    @Query("SELECT lc FROM LocacaoCampo lc WHERE lc.id_administrador = :idAministrador")
    List<LocacaoCampoEntity> consultarLocacoesPorAdministrador(Long idAministrador);
}
