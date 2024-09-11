package gerenciadorsociety.entrypoint.mappers;

import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CampoMapper implements Mapper<Campo, CampoDto> {

    private final Mapper<Estabelecimento, EstabelecimentoDto> mapper;

    @Override
    public Campo paraDomain(CampoDto dto) {
        return Campo.builder()
                .id(dto.id())
                .numero(dto.numero())
                .estabelecimento(mapper.paraDomain(dto.estabelecimento()))
                .build();
    }

    @Override
    public CampoDto paraDto(Campo domain) {
        return CampoDto.builder()
                .id(domain.getId())
                .numero(domain.getNumero())
                .estabelecimento(mapper.paraDto(domain.getEstabelecimento()))
                .build();
    }

    @Override
    public List<CampoDto> paraDtos(List<Campo> domains) {
        return domains.stream().map(this::paraDto).toList();
    }
}
