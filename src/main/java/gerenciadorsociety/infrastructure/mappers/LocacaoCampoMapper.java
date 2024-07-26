package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoCampoDto;
import gerenciadorsociety.infrastructure.repositories.entities.LocacaoCampoEntity;

import java.util.List;

public abstract class LocacaoCampoMapper {

    public static LocacaoCampoEntity paraEntityDeDomain(LocacaoCampo locacaoCampo) {
        return new LocacaoCampoEntity(
                locacaoCampo.getId(),
                EstabelecimentoMapper.paraEntityDeDomain(locacaoCampo.getEstabelecimento()),
                AdministradorMapper.paraEntityDeDomain(locacaoCampo.getAdministrador()),
                locacaoCampo.getDataLocacao(),
                locacaoCampo.getData(),
                locacaoCampo.getHoraLocacao(),
                locacaoCampo.getAtivo(),
                CampoMapper.paraEntityDeDomain(locacaoCampo.getCampo()),
                locacaoCampo.getListaDeJogadores()
        );
    }

    public static LocacaoCampo paraDomainDeEntity(LocacaoCampoEntity locacaoCampoEntity) {
        return new LocacaoCampo(
                locacaoCampoEntity.getId(),
                EstabelecimentoMapper.paraDomainDeEntity(locacaoCampoEntity.getEstabelecimento()),
                AdministradorMapper.paraDomainDeEntiy(locacaoCampoEntity.getAdministrador()),
                locacaoCampoEntity.getDataLocacao(),
                locacaoCampoEntity.getDataAtual(),
                locacaoCampoEntity.getHoraLocacao(),
                locacaoCampoEntity.getAtivo(),
                CampoMapper.paraDomainDeEntity(locacaoCampoEntity.getCampo()),
                locacaoCampoEntity.getListaDeJogadores()
        );
    }

    public static LocacaoCampoDto paraDtoDeDomain(LocacaoCampo locacaoCampo) {
        return new LocacaoCampoDto(
                locacaoCampo.getId(),
                EstabelecimentoMapper.paraDtoDeDomain(locacaoCampo.getEstabelecimento()),
                AdministradorMapper.paraDtoDeDomain(locacaoCampo.getAdministrador()),
                locacaoCampo.getDataLocacao(),
                locacaoCampo.getData(),
                locacaoCampo.getHoraLocacao(),
                locacaoCampo.getAtivo(),
                CampoMapper.paraDtoDeDomain(locacaoCampo.getCampo()),
                locacaoCampo.getListaDeJogadores()
        );
    }

    public static LocacaoCampo paraDomainDeDto(LocacaoCampoDto locacaoCampoDto) {
        return new LocacaoCampo(
                locacaoCampoDto.getId(),
                EstabelecimentoMapper.paraDomainDeDto(locacaoCampoDto.getEstabelecimento()),
                AdministradorMapper.paraDomainDeDto(locacaoCampoDto.getAdministrador()),
                locacaoCampoDto.getDataLocacao(),
                locacaoCampoDto.getData(),
                locacaoCampoDto.getHoraLocacao(),
                locacaoCampoDto.getAtivo(),
                CampoMapper.paraDomainDeDto(locacaoCampoDto.getCampo()),
                locacaoCampoDto.getListaDeJogadores()
        );
    }

    public static List<LocacaoCampo> paraDomainsDeEntitys(List<LocacaoCampoEntity> locacaoCampoEntities) {
        return locacaoCampoEntities.stream().map(LocacaoCampoMapper::paraDomainDeEntity).toList();
    }

    public static List<LocacaoCampoDto> paraDtosDeDomains(List<LocacaoCampo> locacaoCampoList) {
        return locacaoCampoList.stream().map(LocacaoCampoMapper::paraDtoDeDomain).toList();
    }

}
