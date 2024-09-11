package gerenciadorsociety.entrypoint.mappers;

import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.domain.usuarios.Jogador;
import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoCampoDto;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
import gerenciadorsociety.entrypoint.dtos.usuarios.JogadorDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LocacaoCampoMapper implements Mapper<LocacaoCampo, LocacaoCampoDto> {

    private final Mapper<Estabelecimento, EstabelecimentoDto> estabelecimentoMapper;
    private final Mapper<Administrador, AdministradorDto> administradorMapper;
    private final Mapper<Campo, CampoDto> campoMapper;
    private final Mapper<Jogador, JogadorDto> jogadorMapper;

    @Override
    public LocacaoCampo paraDomain(LocacaoCampoDto locacaoCampoDto) {
        return new LocacaoCampo(
                locacaoCampoDto.getId(),
                estabelecimentoMapper.paraDomain(locacaoCampoDto.getEstabelecimento()),
                administradorMapper.paraDomain(locacaoCampoDto.getAdministrador()),
                locacaoCampoDto.getDataLocacao(),
                locacaoCampoDto.getData(),
                locacaoCampoDto.getHoraLocacao(),
                locacaoCampoDto.getAtivo(),
                campoMapper.paraDomain(locacaoCampoDto.getCampo()),
                locacaoCampoDto.getListaDeJogadores().stream().map(jogadorMapper::paraDomain).toList()
        );
    }

    @Override
    public LocacaoCampoDto paraDto(LocacaoCampo domain) {
        return new LocacaoCampoDto(
                domain.getId(),
                estabelecimentoMapper.paraDto(domain.getEstabelecimento()),
                administradorMapper.paraDto(domain.getAdministrador()),
                domain.getDataLocacao(),
                domain.getData(),
                domain.getHoraLocacao(),
                domain.getAtivo(),
                campoMapper.paraDto(domain.getCampo()),
                jogadorMapper.paraDtos(domain.getListaDeJogadores())
        );
    }

    @Override
    public List<LocacaoCampoDto> paraDtos(List<LocacaoCampo> domains) {
        return domains.stream().map(this::paraDto).toList();
    }
}
