package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.domain.locacao.LocacaoChurrasqueira;
import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoChurrasqueiraDto;
import gerenciadorsociety.infrastructure.repositories.entities.ChurrasqueiraEntity;
import gerenciadorsociety.infrastructure.repositories.entities.EstabelecimentoEntity;
import gerenciadorsociety.infrastructure.repositories.entities.locacao.LocacaoChurrasqueiraEntity;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.AdministradorEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LocacaoChurrasqueiraMapper implements Mapper<LocacaoChurrasqueira, LocacaoChurrasqueiraEntity>{

    private final Mapper<Estabelecimento, EstabelecimentoEntity> estabelecimentoMapper;
    private final Mapper<Administrador, AdministradorEntity> adminsitradorMapper;
    private final Mapper<Churrasqueira, ChurrasqueiraEntity> churrasqueiraMapper;

    @Override
    public LocacaoChurrasqueira paraDomain(LocacaoChurrasqueiraEntity locacaoChurrasqueiraEntity) {
        return new LocacaoChurrasqueira(
                locacaoChurrasqueiraEntity.getId(),
                estabelecimentoMapper.paraDomain(locacaoChurrasqueiraEntity.getEstabelecimento()),
                adminsitradorMapper.paraDomain(locacaoChurrasqueiraEntity.getAdministrador()),
                locacaoChurrasqueiraEntity.getDataLocacao(),
                locacaoChurrasqueiraEntity.getDataAtual(),
                locacaoChurrasqueiraEntity.getHoraLocacao(),
                locacaoChurrasqueiraEntity.getAtivo(),
                churrasqueiraMapper.paraDomain(locacaoChurrasqueiraEntity.getChurrasqueira())
        );
    }

    @Override
    public LocacaoChurrasqueiraEntity paraEntity(LocacaoChurrasqueira locacaoChurrasqueira) {
        return new LocacaoChurrasqueiraEntity(
                locacaoChurrasqueira.getId(),
                estabelecimentoMapper.paraEntity(locacaoChurrasqueira.getEstabelecimento()),
                adminsitradorMapper.paraEntity(locacaoChurrasqueira.getAdministrador()),
                locacaoChurrasqueira.getDataLocacao(),
                locacaoChurrasqueira.getData(),
                locacaoChurrasqueira.getHoraLocacao(),
                locacaoChurrasqueira.getAtivo(),
                churrasqueiraMapper.paraEntity(locacaoChurrasqueira.getChurrasqueira())
        );
    }

    @Override
    public List<LocacaoChurrasqueira> paraDomains(List<LocacaoChurrasqueiraEntity> locacaoChurrasqueiraEntityList) {
        return locacaoChurrasqueiraEntityList.stream().map(this::paraDomain).toList();
    }

}
