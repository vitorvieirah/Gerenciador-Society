package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.LocacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<LocacaoEntity, Long> {
}
