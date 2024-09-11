package gerenciadorsociety.infrastructure.repositories;

import gerenciadorsociety.infrastructure.repositories.entities.ChurrasqueiraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChurrasqueiraRepository extends JpaRepository<ChurrasqueiraEntity, Long> {
    Optional<ChurrasqueiraEntity> findByNumero(Integer numero);

    @Query("SELECT * FROM Churrasqueira ch WHERE ch.estabelecimento_id = :idEstabelecimento")
    List<ChurrasqueiraEntity> buscarPorEstabelecimento(Long idEstabelecimento);
}
