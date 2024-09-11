package gerenciadorsociety.infrastructure.mappers;

import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.domain.usuarios.Jogador;
import gerenciadorsociety.infrastructure.repositories.entities.CampoEntity;
import gerenciadorsociety.infrastructure.repositories.entities.EstabelecimentoEntity;
import gerenciadorsociety.infrastructure.repositories.entities.locacao.LocacaoCampoEntity;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.AdministradorEntity;
import gerenciadorsociety.infrastructure.repositories.entities.usuarios.JogadorEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LocacaoCampoMapper implements Mapper<LocacaoCampo, LocacaoCampoEntity> {

    private final Mapper<Estabelecimento, EstabelecimentoEntity> estabelecimentoMapper;
    private final Mapper<Administrador, AdministradorEntity> administradorMapper;
    private final Mapper<Campo, CampoEntity> campoMapper;
    private final Mapper<Jogador, JogadorEntity> jogadorMapper;

    @Override
    public LocacaoCampo paraDomain(LocacaoCampoEntity locacaoCampoEntity) {
        return new LocacaoCampo(
                locacaoCampoEntity.getId(),
                estabelecimentoMapper.paraDomain(locacaoCampoEntity.getEstabelecimento()),
                administradorMapper.paraDomain(locacaoCampoEntity.getAdministrador()),
                locacaoCampoEntity.getDataLocacao(),
                locacaoCampoEntity.getDataAtual(),
                locacaoCampoEntity.getHoraLocacao(),
                locacaoCampoEntity.getAtivo(),
                campoMapper.paraDomain(locacaoCampoEntity.getCampo()),
                jogadorMapper.paraDomains(locacaoCampoEntity.getListaDeJogadores())
        );
    }

    @Override
    public LocacaoCampoEntity paraEntity(LocacaoCampo locacaoCampo) {
        return new LocacaoCampoEntity(
                locacaoCampo.getId(),
                estabelecimentoMapper.paraEntity(locacaoCampo.getEstabelecimento()),
                administradorMapper.paraEntity(locacaoCampo.getAdministrador()),
                locacaoCampo.getDataLocacao(),
                locacaoCampo.getData(),
                locacaoCampo.getHoraLocacao(),
                locacaoCampo.getAtivo(),
                campoMapper.paraEntity(locacaoCampo.getCampo()),
                locacaoCampo.getListaDeJogadores().stream().map(jogadorMapper::paraEntity).toList()
        );
    }

    @Override
    public List<LocacaoCampo> paraDomains(List<LocacaoCampoEntity> locacaoCampoEntities) {
        return locacaoCampoEntities.stream().map(this::paraDomain).toList();
    }
}
