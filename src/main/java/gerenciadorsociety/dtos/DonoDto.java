package gerenciadorsociety.dtos;

import lombok.Builder;

@Builder
public record DonoDto(Long id, String nome, String cpf, String email, String numeroTelefone) {
}
