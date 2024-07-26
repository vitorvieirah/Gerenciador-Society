package gerenciadorsociety.infrastructure.repositories;

import gerenciadorsociety.infrastructure.repositories.entities.ChurrasqueiraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChurrasqueiraRepository extends JpaRepository<ChurrasqueiraEntity, Long> {
    Optional<ChurrasqueiraEntity> findByNumero(Integer numero);
}
