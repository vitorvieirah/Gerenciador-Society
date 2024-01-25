package gerenciadorsociety.infra.mappers;

import gerenciadorsociety.domains.LocacaoCampo;
import gerenciadorsociety.dtos.LocacaoCampoDto;
import gerenciadorsociety.dtos.LocacaoDto;
import gerenciadorsociety.infra.entitys.LocacaoCampoEntity;
import gerenciadorsociety.infra.entitys.LocacaoEntity;

import java.util.List;

public abstract class LocacaoCampoMapper {

    public static LocacaoCampoEntity paraEntityDeDomain (LocacaoCampo locacaoCampo){
        return new LocacaoCampoEntity(
                locacaoCampo.getId(),
                EstabelecimentoMapper.paraEntityDeDomain(locacaoCampo.getEstabelecimento()),
                AdministradorMapper.paraEntityDeDomain(locacaoCampo.getAdministrador()),
                locacaoCampo.getDataLocacao(),
                locacaoCampo.getAtivo(),
                CampoMapper.paraEntityDeDomain(locacaoCampo.getCampo())
        );
    }

    public static LocacaoCampo paraDomainDeEntity (LocacaoCampoEntity locacaoCampoEntity){
        return new LocacaoCampo(
                locacaoCampoEntity.getId(),
                EstabelecimentoMapper.paraDomainDeEntity(locacaoCampoEntity.getEstabelecimento()),
                AdministradorMapper.paraDomainDeEntiy(locacaoCampoEntity.getAdministrador()),
                locacaoCampoEntity.getDataLocacao(),
                locacaoCampoEntity.getAtivo(),
                CampoMapper.paraDomainDeEntity(locacaoCampoEntity.getCampo())
        );
    }

    public static LocacaoCampoDto paraDtoDeDomain (LocacaoCampo locacaoCampo){
        return new LocacaoCampoDto(
                locacaoCampo.getId(),
                EstabelecimentoMapper.paraDtoDeDomain(locacaoCampo.getEstabelecimento()),
                AdministradorMapper.paraDtoDeDomain(locacaoCampo.getAdministrador()),
                locacaoCampo.getDataLocacao(),
                locacaoCampo.getAtivo(),
                CampoMapper.paraDtoDeDomain(locacaoCampo.getCampo())
        );
    }

    public static LocacaoCampo paraDomainDeDto (LocacaoCampoDto locacaoCampoDto){
        return new LocacaoCampo(
                locacaoCampoDto.getId(),
                EstabelecimentoMapper.paraDomainDeDto(locacaoCampoDto.getEstabelecimento()),
                AdministradorMapper.paraDomainDeDto(locacaoCampoDto.getAdministrador()),
                locacaoCampoDto.getDataLocacao(),
                locacaoCampoDto.getAtivo(),
                CampoMapper.paraDomainDeDto(locacaoCampoDto.getCampo())
        );
    }

    public static List<LocacaoCampo> paraDomainsDeEntitys (List<LocacaoCampoEntity> locacaoCampoEntities){
        return locacaoCampoEntities.stream().map(LocacaoCampoMapper::paraDomainDeEntity).toList();
    }

    public static List<LocacaoCampoDto> paraDtosDeDomains (List<LocacaoCampo> locacaoCampoList){
        return locacaoCampoList.stream().map(LocacaoCampoMapper::paraDtoDeDomain).toList();
    }

}
