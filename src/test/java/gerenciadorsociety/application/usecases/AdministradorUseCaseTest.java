package gerenciadorsociety.application.usecases;

import gerenciadorsociety.application.gateways.AdministradorGateway;
import gerenciadorsociety.domain.usuarios.Administrador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AdministradorUseCaseTest {

    @Mock
    private AdministradorGateway gateway;

    @Captor
    ArgumentCaptor<Administrador> captor;

    @InjectMocks
    private AdministradorUseCase useCase;

    @Test
    void testeCadastroAdministrador() {
        Administrador administrador = Administrador.builder()
                .id(1L)
                .cpf("123456789")
                .email("teste@gmail.com")
                .nome("Vitor Teste")
                .numeroTelefone("(44)9+ 6532-8741")
                .build();

        Mockito.when(gateway.consultarPorCpf(administrador.getCpf())).thenReturn(Optional.empty());
        Mockito.when(gateway.salvar(captor.capture())).thenReturn(administrador);

        Administrador administradorRetornoTeste = captor.getValue();

        Assertions.assertEquals(administrador, administradorRetornoTeste);
    }
}
