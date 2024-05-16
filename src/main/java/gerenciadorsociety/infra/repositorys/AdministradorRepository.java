package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Long> {
    Optional<AdministradorEntity> findByCpf(String cpf);
}