package gerenciadorsociety.infrastructure.repositories;

import gerenciadorsociety.infrastructure.repositories.entities.usuarios.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<JogadorEntity, Long> {
}
