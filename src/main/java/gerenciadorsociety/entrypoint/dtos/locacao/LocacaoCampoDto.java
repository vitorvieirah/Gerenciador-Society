package gerenciadorsociety.entrypoint.dtos.locacao;


import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.entrypoint.dtos.EstabelecimentoDto;
import gerenciadorsociety.entrypoint.dtos.usuarios.AdministradorDto;
import gerenciadorsociety.entrypoint.dtos.usuarios.JogadorDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@Getter
@ToString
public class LocacaoCampoDto extends LocacaoDto {

    private CampoDto campo;
    private List<JogadorDto> listaDeJogadores;

    public LocacaoCampoDto(Long id, EstabelecimentoDto estabelecimento, AdministradorDto administrador, LocalDate dataLocacao,
                           LocalDate data, LocalTime horaLocacao, Boolean ativo, CampoDto campo, List<JogadorDto> list) {
        super(id, estabelecimento, administrador, dataLocacao, data, horaLocacao, ativo);
        this.campo = campo;
        this.listaDeJogadores = list;
    }
}
