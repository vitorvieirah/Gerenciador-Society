package gerenciadorsociety.infrastructure.repositories;

import gerenciadorsociety.infrastructure.repositories.entities.locacao.LocacaoChurrasqueiraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface LocacaoChurrasqueiraRepository extends JpaRepository<LocacaoChurrasqueiraEntity, Long> {

    @Query("SELECT lch FROM LocacaoChurrasqueira lch " +
            "WHERE lch.horaLocacao = :horaLocacao AND " +
            "lch.dataLocacao = :dataLocacao AND" +
            "lch.churrasqueira.numero = :numero")
    Optional<LocacaoChurrasqueiraEntity> findByLocacaoValidacao(LocalTime horaLocacao, LocalDate dataLocacao, Integer numero);

    @Query("SELECT lch FROM LocacaoChurrasqueira lch WHERE lch.id_administrador = :idAdministrador")
    List<LocacaoChurrasqueiraEntity> consultarPorAdministrador(Long idAdministrador);
}
