package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.EstabelecimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoEntity, Long> {
    Optional<EstabelecimentoEntity> findByCnpj(String cnpj);
}
