package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<AdministradorEntity, String> {
    AdministradorEntity getReferenceByCpf(String cpf);
}
