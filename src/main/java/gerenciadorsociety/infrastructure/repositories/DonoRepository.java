package gerenciadorsociety.infrastructure.repositories;

import gerenciadorsociety.infrastructure.repositories.entities.usuarios.DonoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonoRepository extends JpaRepository<DonoEntity, Long> {
    Optional<DonoEntity> findByCpf(String cpf);
}
