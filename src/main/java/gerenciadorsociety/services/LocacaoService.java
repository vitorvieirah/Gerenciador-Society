package gerenciadorsociety.services;

import gerenciadorsociety.dtos.LocacaoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LocacaoService {
    public void cancelar(Long id) {
    }

    public List<LocacaoDto> getLocacoes() {
        return new ArrayList<>();
    }
}
