package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.LocacaoChurrasqueiraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface LocacaoChurrasqueiraRepository extends JpaRepository<LocacaoChurrasqueiraEntity, Long> {

    @Query("SELECT lch FROM LocacaoChurrasqueiraEntity lch WHERE lch.horaLocacao = :horaLocacao AND lch.dataLocacao = :dataLocacao AND lch.churrasqueira.numero = :numero")
    Optional<LocacaoChurrasqueiraEntity> findByLocacaoValidacao (LocalTime horaLocacao, LocalDate dataLocacao, Integer numero);
}
