package gerenciadorsociety.application.mappers;

import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class ChurrasqueiraMapper implements Mapper<Churrasqueira, ChurrasqueiraDto> {

    private final Mapper<Estabelecimento, EstabelecimentoDto> mapper;

    @Override
    public Churrasqueira paraDomain(ChurrasqueiraDto dto) {
        return Churrasqueira.builder()
                .id(dto.id())
                .numero(dto.numero())
                .estabelecimento(mapper.paraDomain(dto.estabelecimento()))
                .build();
    }

    @Override
    public ChurrasqueiraDto paraDto(Churrasqueira domain) {
        return ChurrasqueiraDto.builder()
                .id(domain.getId())
                .numero(domain.getNumero())
                .estabelecimento(mapper.paraDto(domain.getEstabelecimento()))
                .build();
    }

    @Override
    public List<ChurrasqueiraDto> paraDtos(List<Churrasqueira> domains) {
        return domains.stream().map(this::paraDto).toList();
    }
}
