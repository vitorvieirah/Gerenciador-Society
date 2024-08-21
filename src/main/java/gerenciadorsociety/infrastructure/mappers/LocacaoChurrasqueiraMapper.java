package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.locacao.LocacaoChurrasqueira;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoChurrasqueiraDto;
import gerenciadorsociety.infrastructure.repositories.entities.locacao.LocacaoChurrasqueiraEntity;

import java.util.List;

public abstract class LocacaoChurrasqueiraMapper {

    public static LocacaoChurrasqueiraEntity paraDomainDeDomain(LocacaoChurrasqueira locacaoChurrasqueira) {
        return new LocacaoChurrasqueiraEntity(
                locacaoChurrasqueira.getId(),
                EstabelecimentoMapper.paraDomainDeDomain(locacaoChurrasqueira.getEstabelecimento()),
                AdministradorMapper.paraDomainDeDomain(locacaoChurrasqueira.getAdministrador()),
                locacaoChurrasqueira.getDataLocacao(),
                locacaoChurrasqueira.getData(),
                locacaoChurrasqueira.getHoraLocacao(),
                locacaoChurrasqueira.getAtivo(),
                ChurrasqueiraMapper.paraDomainDeDomain(locacaoChurrasqueira.getChurrasqueira())
        );
    }

    public static LocacaoChurrasqueira paraDomain(LocacaoChurrasqueiraEntity locacaoChurrasqueiraEntity) {
        return new LocacaoChurrasqueira(
                locacaoChurrasqueiraEntity.getId(),
                EstabelecimentoMapper.paraDomain(locacaoChurrasqueiraEntity.getEstabelecimento()),
                AdministradorMapper.paraDomainDeEntiy(locacaoChurrasqueiraEntity.getAdministrador()),
                locacaoChurrasqueiraEntity.getDataLocacao(),
                locacaoChurrasqueiraEntity.getDataAtual(),
                locacaoChurrasqueiraEntity.getHoraLocacao(),
                locacaoChurrasqueiraEntity.getAtivo(),
                ChurrasqueiraMapper.paraDomain(locacaoChurrasqueiraEntity.getChurrasqueira())
        );
    }

    public static List<LocacaoChurrasqueira> paraDomainsDeEntitys(List<LocacaoChurrasqueiraEntity> locacaoChurrasqueiraEntityList) {
        return locacaoChurrasqueiraEntityList.stream().map(LocacaoChurrasqueiraMapper::paraDomain).toList();
    }

}
