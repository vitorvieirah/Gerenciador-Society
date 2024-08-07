package gerenciadorsociety.entrypoint.dtos.usuarios;

import gerenciadorsociety.domain.Endereco;
import lombok.Builder;

@Builder
public record JogadorDto(Long id, String nome, String email, String numeroTelefone, String cpf, Endereco endereco) {
}
