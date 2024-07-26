package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.locacao.LocacaoChurrasqueira;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoChurrasqueiraDto;
import gerenciadorsociety.infrastructure.repositories.entities.LocacaoChurrasqueiraEntity;

import java.util.List;

public abstract class LocacaoChurrasqueiraMapper {

    public static LocacaoChurrasqueiraEntity paraEntityDeDomain(LocacaoChurrasqueira locacaoChurrasqueira) {
        return new LocacaoChurrasqueiraEntity(
                locacaoChurrasqueira.getId(),
                EstabelecimentoMapper.paraEntityDeDomain(locacaoChurrasqueira.getEstabelecimento()),
                AdministradorMapper.paraEntityDeDomain(locacaoChurrasqueira.getAdministrador()),
                locacaoChurrasqueira.getDataLocacao(),
                locacaoChurrasqueira.getData(),
                locacaoChurrasqueira.getHoraLocacao(),
                locacaoChurrasqueira.getAtivo(),
                ChurrasqueiraMapper.paraEntityDeDomain(locacaoChurrasqueira.getChurrasqueira())
        );
    }

    public static LocacaoChurrasqueira paraDomainDeEntity(LocacaoChurrasqueiraEntity locacaoChurrasqueiraEntity) {
        return new LocacaoChurrasqueira(
                locacaoChurrasqueiraEntity.getId(),
                EstabelecimentoMapper.paraDomainDeEntity(locacaoChurrasqueiraEntity.getEstabelecimento()),
                AdministradorMapper.paraDomainDeEntiy(locacaoChurrasqueiraEntity.getAdministrador()),
                locacaoChurrasqueiraEntity.getDataLocacao(),
                locacaoChurrasqueiraEntity.getDataAtual(),
                locacaoChurrasqueiraEntity.getHoraLocacao(),
                locacaoChurrasqueiraEntity.getAtivo(),
                ChurrasqueiraMapper.paraDomainDeEntity(locacaoChurrasqueiraEntity.getChurrasqueira())
        );
    }

    public static LocacaoChurrasqueiraDto paraDtoDeDomain(LocacaoChurrasqueira locacaoChurrasqueira) {
        return new LocacaoChurrasqueiraDto(
                locacaoChurrasqueira.getId(),
                EstabelecimentoMapper.paraDtoDeDomain(locacaoChurrasqueira.getEstabelecimento()),
                AdministradorMapper.paraDtoDeDomain(locacaoChurrasqueira.getAdministrador()),
                locacaoChurrasqueira.getDataLocacao(),
                locacaoChurrasqueira.getData(),
                locacaoChurrasqueira.getHoraLocacao(),
                locacaoChurrasqueira.getAtivo(),
                ChurrasqueiraMapper.paraDtoDeDomain(locacaoChurrasqueira.getChurrasqueira())
        );
    }

    public static LocacaoChurrasqueira paraDomainDeDto(LocacaoChurrasqueiraDto locacaoChurrasqueiraDto) {
        return new LocacaoChurrasqueira(
                locacaoChurrasqueiraDto.getId(),
                EstabelecimentoMapper.paraDomainDeDto(locacaoChurrasqueiraDto.getEstabelecimento()),
                AdministradorMapper.paraDomainDeDto(locacaoChurrasqueiraDto.getAdministrador()),
                locacaoChurrasqueiraDto.getDataLocacao(),
                locacaoChurrasqueiraDto.getData(),
                locacaoChurrasqueiraDto.getHoraLocacao(),
                locacaoChurrasqueiraDto.getAtivo(),
                ChurrasqueiraMapper.paraDomainDeDto(locacaoChurrasqueiraDto.getChurrasqueira())
        );
    }

    public static List<LocacaoChurrasqueira> paraDomainsDeEntitys(List<LocacaoChurrasqueiraEntity> locacaoChurrasqueiraEntityList) {
        return locacaoChurrasqueiraEntityList.stream().map(LocacaoChurrasqueiraMapper::paraDomainDeEntity).toList();
    }

    public static List<LocacaoChurrasqueiraDto> paraDtosDeDomains(List<LocacaoChurrasqueira> locacaoChurrasqueiraList) {
        return locacaoChurrasqueiraList.stream().map(LocacaoChurrasqueiraMapper::paraDtoDeDomain).toList();
    }

}
