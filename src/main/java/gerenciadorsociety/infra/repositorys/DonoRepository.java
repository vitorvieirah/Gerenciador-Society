package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.DonoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoRepository extends JpaRepository<DonoEntity, String> {
    DonoEntity getReferenceByCpf(String cpf);
}
