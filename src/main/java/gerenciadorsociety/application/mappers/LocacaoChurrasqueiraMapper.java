package gerenciadorsociety.application.mappers;

import gerenciadorsociety.domain.Churrasqueira;
import gerenciadorsociety.domain.Estabelecimento;
import gerenciadorsociety.domain.locacao.LocacaoChurrasqueira;
import gerenciadorsociety.domain.usuarios.Administrador;
import gerenciadorsociety.domain.usuarios.Jogador;
import gerenciadorsociety.entrypoint.dtos.ChurrasqueiraDto;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import gerenciadorsociety.entrypoint.dtos.locacao.LocacaoChurrasqueiraDto;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
import gerenciadorsociety.entrypoint.dtos.usuarios.JogadorDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LocacaoChurrasqueiraMapper implements Mapper<LocacaoChurrasqueira, LocacaoChurrasqueiraDto> {

    private final Mapper<Estabelecimento, EstabelecimentoDto> estabelecimentoMapper;
    private final Mapper<Administrador, AdministradorDto> administradorMapper;
    private final Mapper<Churrasqueira, ChurrasqueiraDto> churrasqueiraMapper;
    private final Mapper<Jogador, JogadorDto> jogadorMapper;


    @Override
    public LocacaoChurrasqueira paraDomain(LocacaoChurrasqueiraDto dto) {
        return new LocacaoChurrasqueira(
                dto.getId(),
                estabelecimentoMapper.paraDomain(dto.getEstabelecimento()),
                administradorMapper.paraDomain(dto.getAdministrador()),
                dto.getDataLocacao(),
                dto.getData(),
                dto.getHoraLocacao(),
                dto.getAtivo(),
                churrasqueiraMapper.paraDomain(dto.getChurrasqueira())
        );
    }

    @Override
    public LocacaoChurrasqueiraDto paraDto(LocacaoChurrasqueira domain) {
        return new LocacaoChurrasqueiraDto(
                domain.getId(),
                estabelecimentoMapper.paraDto(domain.getEstabelecimento()),
                administradorMapper.paraDto(domain.getAdministrador()),
                domain.getDataLocacao(),
                domain.getData(),
                domain.getHoraLocacao(),
                domain.getAtivo(),
                churrasqueiraMapper.paraDto(domain.getChurrasqueira())
        );
    }

    @Override
    public List<LocacaoChurrasqueiraDto> paraDtos(List<LocacaoChurrasqueira> domains) {
        return domains.stream().map(this::paraDto).toList();
    }
}
