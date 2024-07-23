package gerenciadorsociety.infra.dataprovider;

public interface DataProvider<D> {

    D salvar(D domain);
    void deletar(Long id);
}
