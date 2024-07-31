package gerenciadorsociety.infrastructure.repositories;

import gerenciadorsociety.infrastructure.repositories.entities.CampoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampoRepository extends JpaRepository<CampoEntity, Long> {
    Optional<CampoEntity> findByNumero(Integer numero);

    @Query("SELECT * FROM Campo WHERE Campo.estabelecimento_id = :idEstabelecimento")
    List<CampoEntity> buscarPorEstabelecimento(Long idEstabelecimento);
}
