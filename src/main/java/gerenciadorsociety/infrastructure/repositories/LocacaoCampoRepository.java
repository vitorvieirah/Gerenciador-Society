package gerenciadorsociety.infrastructure.repositories;

import gerenciadorsociety.infrastructure.repositories.entities.LocacaoCampoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface LocacaoCampoRepository extends JpaRepository<LocacaoCampoEntity, Long> {

    @Query("SELECT lc " +
            "FROM LocacaoCampoEntity lc " +
            "WHERE lc.horaLocacao = :horaLocacao AND " +
            "lc.dataLocacao = :dataLocacao AND " +
            "lc.campo.numero = :numeroCampo")
    Optional<LocacaoCampoEntity> findLocacaoValidacao(LocalTime horaLocacao, LocalDate dataLocacao, Integer numeroCampo);
}
