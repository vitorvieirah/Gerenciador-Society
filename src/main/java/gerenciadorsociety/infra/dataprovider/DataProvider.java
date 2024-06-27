package gerenciadorsociety.infra.dataprovider;

import java.util.List;

public interface DataProvider <D>{
    D salvar(D domain);

    void deletar(Long id);
}
