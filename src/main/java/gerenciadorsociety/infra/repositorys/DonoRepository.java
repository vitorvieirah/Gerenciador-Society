package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.DonoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonoRepository extends JpaRepository<DonoEntity, Long> {
    Optional<DonoEntity> findByCpf(String cpf);
}
