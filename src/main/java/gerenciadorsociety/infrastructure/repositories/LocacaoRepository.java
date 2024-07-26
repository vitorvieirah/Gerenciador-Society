package gerenciadorsociety.infrastructure.repositories;

import gerenciadorsociety.infrastructure.repositories.entities.LocacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<LocacaoEntity, Long> {
}
