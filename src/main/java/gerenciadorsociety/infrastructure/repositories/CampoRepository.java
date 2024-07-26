package gerenciadorsociety.infrastructure.repositories;

import gerenciadorsociety.infrastructure.repositories.entities.CampoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampoRepository extends JpaRepository<CampoEntity, Long> {
    Optional<CampoEntity> findByNumero(Integer numero);
}
