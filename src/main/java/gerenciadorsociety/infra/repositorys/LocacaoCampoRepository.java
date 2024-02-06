package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.LocacaoCampoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface LocacaoCampoRepository extends JpaRepository<LocacaoCampoEntity, Long> {
    @Query("SELECT lc FROM LocacaoCampoEntity lc WHERE lc.horaLocacao = :horaLocacao AND lc.dataLocacao = :dataLocacao AND lc.campo.numeroCampo = :numeroCampo")
    Optional<LocacaoCampoEntity> findByLocacaoValidacao(LocalTime horaLocacao, LocalDate dataLocacao, Integer numeroCampo);
}
