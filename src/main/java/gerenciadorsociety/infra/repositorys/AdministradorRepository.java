package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity, String> {
}
