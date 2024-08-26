package gerenciadorsociety.application.services;

import gerenciadorsociety.application.exceptions.UseCaseException;
import gerenciadorsociety.application.gateways.CampoGateway;
import gerenciadorsociety.domain.Campo;
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


    public Campo cadastrar(Campo novoCampo) {
        var campoExistente = buscarPorNumero(novoCampo.getNumero());

        if (campoExistente != null) {
            throw new UseCaseException("Campo já cadastrado");
        }

        novoCampo.setEstabelecimento(estabelecimentoService.consultarPorCnpj(novoCampo.getEstabelecimento().getCnpj()));

        return campoGateway.salvar(novoCampo);
    }

    public Campo alterar(Campo novosDados, Long id) {

        var campo = buscarPorId(id);

        campo.setInformacoes(novosDados);

        return campoGateway.salvar(campo);
    }

    public Campo buscarPorNumero(Integer numero) {
        Optional<Campo> campoExistente = campoGateway.buscarPorNumero(numero);

        if (campoExistente.isEmpty())
            throw new UseCaseException(MENSAGEM_CAMPO_NAO_ENCONTRADO);

        return campoExistente.get();
    }

    public List<Campo> buscarPorEstabelecimento(Long idEstabelecimento) {
        return campoGateway.buscarPorEstabelecimento(idEstabelecimento);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        campoGateway.deletar(id);
    }

    public Campo buscarPorId(Long idCampo) {
        Optional<Campo> campo = campoGateway.buscarPorId(idCampo);

        if (campo.isEmpty())
            throw new UseCaseException(MENSAGEM_CAMPO_NAO_ENCONTRADO);

        return campo.get();
    }
}
