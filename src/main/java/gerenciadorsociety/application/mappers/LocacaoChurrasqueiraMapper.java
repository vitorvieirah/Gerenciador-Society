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
    public LocacaoChurrasqueira paraDomainDeDto(LocacaoChurrasqueiraDto dto) {
        return new LocacaoChurrasqueira(
                dto.getId(),
                estabelecimentoMapper.paraDomainDeDto(dto.getEstabelecimento()),
                administradorMapper.paraDomainDeDto(dto.getAdministrador()),
                dto.getDataLocacao(),
                dto.getData(),
                dto.getHoraLocacao(),
                dto.getAtivo(),
                churrasqueiraMapper.paraDomainDeDto(dto.getChurrasqueira())
        );
    }

    @Override
    public LocacaoChurrasqueiraDto paraDtoDeDomain(LocacaoChurrasqueira domain) {
        return new LocacaoChurrasqueiraDto(
                domain.getId(),
                estabelecimentoMapper.paraDtoDeDomain(domain.getEstabelecimento()),
                administradorMapper.paraDtoDeDomain(domain.getAdministrador()),
                domain.getDataLocacao(),
                domain.getData(),
                domain.getHoraLocacao(),
                domain.getAtivo(),
                churrasqueiraMapper.paraDtoDeDomain(domain.getChurrasqueira())
        );
    }

    @Override
    public List<LocacaoChurrasqueiraDto> paraDtosDeDomains(List<LocacaoChurrasqueira> domains) {
        return domains.stream().map(this::paraDtoDeDomain).toList();
    }
}
