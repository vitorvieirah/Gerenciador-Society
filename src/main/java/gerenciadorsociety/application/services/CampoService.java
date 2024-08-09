package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.CampoGateway;
import gerenciadorsociety.domain.Campo;
import gerenciadorsociety.domain.locacao.LocacaoCampo;
import gerenciadorsociety.entrypoint.dtos.CampoDto;
import gerenciadorsociety.infrastructure.mappers.CampoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CampoService {

    private final CampoGateway campoGateway;
    private final EstabelecimentoService estabelecimentoService;
    private final String MENSAGEM_CAMPO_NAO_ENCONTRADO = "Campo não econtrado";


    public CampoDto cadastrar(CampoDto campoDto) {
        var campoExistente = buscarPorNumero(campoDto.numero());

        if(campoExistente != null){
            throw new UseCaseException("Campo já cadastrado");
        }

        Campo campo = CampoMapper.paraDomainDeDto(campoDto);

        campo.setEstabelecimento(estabelecimentoService.consultarPorCnpj(campoDto.estabelecimento().cnpj()));

        return CampoMapper.paraDtoDeDomain(campoGateway.salvar(campo));
    }

    public CampoDto alterar(CampoDto campoDto, Long id){

        var campo = buscarPorId(id);

        campo.setInformacoes(campoDto);

        return CampoMapper.paraDtoDeDomain(campoGateway.salvar(campo));
    }

    public Campo buscarPorNumero(Integer numero) {
        Optional<Campo> campoExistente = campoGateway.buscarPorNumero(numero);

        if (campoExistente.isEmpty())
            throw new UseCaseException(MENSAGEM_CAMPO_NAO_ENCONTRADO);

        return campoExistente.get();
    }

    public List<CampoDto> buscarPorEstabelecimento(Long idEstabelecimento){
        List<Campo> campos = campoGateway.buscarPorEstabelecimento(idEstabelecimento);
        return CampoMapper.paraDtosDeDomains(campos);
    }

    public void deletar(Long id){
        campoGateway.deletar(id);
    }

    public Campo buscarPorId(Long idCampo) {
        Optional<Campo> campo = campoGateway.buscarPorId(idCampo);

        if(campo.isEmpty())
            throw new UseCaseException(MENSAGEM_CAMPO_NAO_ENCONTRADO);

        return campo.get();
    }
}
