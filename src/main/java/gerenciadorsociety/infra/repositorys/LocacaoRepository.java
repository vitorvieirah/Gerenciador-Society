package gerenciadorsociety.infra.repositorys;

import gerenciadorsociety.infra.entitys.LocacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocacaoRepository extends JpaRepository<LocacaoEntity, Long> {

    @Query("SELECT lch FROM LocacaoChurrasqueiraEntity lch " +
            "UNION " +
            "SELECT lc FROM LocacaoCampoEntity lc")
    List<LocacaoEntity> findAllLocacoes();
}
