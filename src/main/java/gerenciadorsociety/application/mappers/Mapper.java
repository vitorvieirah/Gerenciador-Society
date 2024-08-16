package gerenciadorsociety.application.mappers;

import java.util.List;

public interface Mapper<D, DTO>{
    D paraDomainDeDto(DTO dto);
    DTO paraDtoDeDomain(D domain);
    List<DTO> paraDtosDeDomains(List<D> domains);
}
