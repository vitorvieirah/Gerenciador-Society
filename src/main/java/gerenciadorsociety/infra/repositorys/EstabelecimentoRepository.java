package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.EstabelecimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoEntity, String> {
}
