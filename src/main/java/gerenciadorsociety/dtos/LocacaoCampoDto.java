package gerenciadorsociety.dtos;

import gerenciadorsociety.domains.LocacaoCampo;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@Getter
@ToString
public class LocacaoCampoDto extends LocacaoDto {
    private CampoDto campo;
    private List<String> listaDeJogadores;

    public LocacaoCampoDto(Long id, EstabelecimentoDto estabelecimento, AdministradorDto administrador, LocalDate dataLocacao, LocalDate data, LocalTime horaLocacao, Boolean ativo, CampoDto campo, List<String> list){
        super(id, estabelecimento, administrador, dataLocacao, data, horaLocacao, ativo);
        this.campo = campo;
        this.listaDeJogadores = list;
    }
}
