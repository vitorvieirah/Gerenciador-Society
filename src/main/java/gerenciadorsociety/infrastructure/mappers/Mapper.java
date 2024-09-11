package gerenciadorsociety.infrastructure.mappers;

import java.util.List;

public interface Mapper<D, E> {
    D paraDomain(E entity);

    E paraEntity(D domain);

    List<D> paraDomains(List<E> entities);
}
