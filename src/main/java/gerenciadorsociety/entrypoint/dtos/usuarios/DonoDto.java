package gerenciadorsociety.entrypoint.dtos.usuarios;

import lombok.Builder;

@Builder
public record DonoDto(Long id, String nome, String cpf, String email, String numeroTelefone) {
}
