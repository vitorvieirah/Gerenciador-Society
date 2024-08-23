package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.domain.usuarios.Dono;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import gerenciadorsociety.infrastructure.repositories.entities.EstabelecimentoEntity;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.DonoEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EstabelecimentoMapper implements Mapper<Estabelecimento, EstabelecimentoEntity>{

    private final Mapper<Dono, DonoEntity> donoMapper;

    @Override
    public Estabelecimento paraDomain(EstabelecimentoEntity estabEntity) {
        return Estabelecimento.builder()
                .id(estabEntity.getId())
                .cnpj(estabEntity.getCnpj())
                .nome(estabEntity.getNome())
                .dono(donoMapper.paraDomain(estabEntity.getDono()))
                .valorHora(estabEntity.getValorHora())
                .build();
    }

    @Override
    public EstabelecimentoEntity paraEntity(Estabelecimento estabelecimento) {
        return EstabelecimentoEntity.builder()
                .id(estabelecimento.getId())
                .cnpj(estabelecimento.getCnpj())
                .nome(estabelecimento.getNome())
                .dono(donoMapper.paraEntity(estabelecimento.getDono()))
                .valorHora(estabelecimento.getValorHora())
                .build();
    }

    @Override
    public List<Estabelecimento> paraDomains(List<EstabelecimentoEntity> estabEntityList) {
        return estabEntityList.stream().map(this::paraDomain).toList();
    }

}
