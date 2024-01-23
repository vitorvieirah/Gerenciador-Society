package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.domains.LocacaoCampo;
import gerenciadorsociety.infra.entitys.LocacaoCampoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoCampoRepository extends JpaRepository<LocacaoCampoEntity, Long> {
}
