package gerenciadorsociety.application.mappers;

import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.infrastructure.mappers.EstabelecimentoMapper;

import java.util.List;

public class CampoMapper implements Mapper<Campo, CampoDto>{
    @Override
    public Campo paraDomainDeDto(CampoDto dto) {
        return Campo.builder()
                .id(dto.id())
                .numero(dto.numero())
                .estabelecimento(EstabelecimentoMapper.paraDomainDeDto(dto.estabelecimento()))
                .build();
    }

    @Override
    public CampoDto paraDtoDeDomain(Campo domain) {
        return CampoDto.builder()
                .id(domain.getId())
                .numero(domain.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDtoDeDomain(domain.getEstabelecimento()))
                .build();
    }

    @Override
    public List<CampoDto> paraDtosDeDomains(List<Campo> domains) {
        return domains.stream().map(this::paraDtoDeDomain).toList();
    }
}
