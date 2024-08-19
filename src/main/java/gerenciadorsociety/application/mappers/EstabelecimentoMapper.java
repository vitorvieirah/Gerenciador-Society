package gerenciadorsociety.application.mappers;

import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.dtos.EstabelecimentoDto;
import gerenciadorsociety.entrypoint.dtos.usuarios.DonoDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EstabelecimentoMapper implements Mapper<Estabelecimento, EstabelecimentoDto> {

    private final Mapper<Dono, DonoDto> mapper;

    @Override
    public Estabelecimento paraDomainDeDto(EstabelecimentoDto dto) {
        return Estabelecimento.builder()
                .id(dto.id())
                .nome(dto.nome())
                .cnpj(dto.cnpj())
                .dono(mapper.paraDomainDeDto(dto.dono()))
                .valorHora(dto.valorHora())
                .build();
    }

    @Override
    public EstabelecimentoDto paraDtoDeDomain(Estabelecimento domain) {
        return EstabelecimentoDto.builder()
                .id(domain.getId())
                .cnpj(domain.getCnpj())
                .nome(domain.getNome())
                .dono(mapper.paraDtoDeDomain(domain.getDono()))
                .valorHora(domain.getValorHora())
                .build();
    }

    @Override
    public List<EstabelecimentoDto> paraDtosDeDomains(List<Estabelecimento> domains) {
        return domains.stream().map(this::paraDtoDeDomain).toList();
    }
}
