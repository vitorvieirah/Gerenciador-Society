package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.infrastructure.repositories.entities.CampoEntity;
import gerenciadorsociety.infrastructure.repositories.entities.EstabelecimentoEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CampoMapper implements Mapper<Campo, CampoEntity> {

    private final Mapper<Estabelecimento, EstabelecimentoEntity> estabelecimentoMapper;

    @Override
    public Campo paraDomain(CampoEntity campoEntity) {
        return Campo.builder()
                .id(campoEntity.getId())
                .numero(campoEntity.getNumero())
                .estabelecimento(estabelecimentoMapper.paraDomain(campoEntity.getEstabelecimento()))
                .build();
    }

    @Override
    public CampoEntity paraEntity(Campo campo) {
        return CampoEntity.builder()
                .id(campo.getId())
                .numero(campo.getNumero())
                .estabelecimento(estabelecimentoMapper.paraEntity(campo.getEstabelecimento()))
                .build();
    }

    @Override
    public List<Campo> paraDomains(List<CampoEntity> campoEntities) {
        return campoEntities.stream().map(this::paraDomain).toList();
    }
}
