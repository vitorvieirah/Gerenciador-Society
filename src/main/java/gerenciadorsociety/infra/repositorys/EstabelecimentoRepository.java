package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.EstabelecimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoEntity, String> {
    EstabelecimentoEntity getReferenceByCnpj(String cnpj);
}
