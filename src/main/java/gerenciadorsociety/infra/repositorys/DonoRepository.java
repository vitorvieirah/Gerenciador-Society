package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.DonoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonoRepository extends JpaRepository<DonoEntity, String> {
}
