package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoCampoDto;
import gerenciadorsociety.infrastructure.repositories.entities.locacao.LocacaoCampoEntity;

import java.util.List;

public abstract class LocacaoCampoMapper {

    public static LocacaoCampoEntity paraDomainDeDomain(LocacaoCampo locacaoCampo) {
        return new LocacaoCampoEntity(
                locacaoCampo.getId(),
                EstabelecimentoMapper.paraDomainDeDomain(locacaoCampo.getEstabelecimento()),
                AdministradorMapper.paraDomainDeDomain(locacaoCampo.getAdministrador()),
                locacaoCampo.getDataLocacao(),
                locacaoCampo.getData(),
                locacaoCampo.getHoraLocacao(),
                locacaoCampo.getAtivo(),
                CampoMapper.paraDomainDeDomain(locacaoCampo.getCampo()),
                locacaoCampo.getListaDeJogadores()
        );
    }

    public static LocacaoCampo paraDomain(LocacaoCampoEntity locacaoCampoEntity) {
        return new LocacaoCampo(
                locacaoCampoEntity.getId(),
                EstabelecimentoMapper.paraDomain(locacaoCampoEntity.getEstabelecimento()),
                AdministradorMapper.paraDomainDeEntiy(locacaoCampoEntity.getAdministrador()),
                locacaoCampoEntity.getDataLocacao(),
                locacaoCampoEntity.getDataAtual(),
                locacaoCampoEntity.getHoraLocacao(),
                locacaoCampoEntity.getAtivo(),
                CampoMapper.paraDomain(locacaoCampoEntity.getCampo()),
                locacaoCampoEntity.getListaDeJogadores()
        );
    }

    public static List<LocacaoCampo> paraDomainsDeEntitys(List<LocacaoCampoEntity> locacaoCampoEntities) {
        return locacaoCampoEntities.stream().map(LocacaoCampoMapper::paraDomain).toList();
    }
}
