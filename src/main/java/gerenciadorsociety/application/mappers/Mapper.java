package gerenciadorsociety.application.mappers;

import java.util.List;

public interface Mapper<D, DTO>{
    D paraDomain(DTO dto);
    DTO paraDto(D domain);
    List<DTO> paraDtos(List<D> domains);
}
