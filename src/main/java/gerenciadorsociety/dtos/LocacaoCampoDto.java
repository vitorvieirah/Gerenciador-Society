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

    public LocacaoCampoDto(Long id, EstabelecimentoDto estab, AdministradorDto adm, LocalDate dataLocacao, LocalDate data, LocalTime horaLocacao, Boolean ativo, CampoDto campo, List<String> list){
        this.id = id;
        this.estabelecimento = estab;
        this.administrador = adm;
        this.dataLocacao = dataLocacao;
        this.data = data;
        this.horaLocacao = horaLocacao;
        this.ativo = ativo;
        this.campo = campo;
        this.listaDeJogadores = list;
    }
}
