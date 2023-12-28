package gerenciadorsociety.dtos;

import lombok.Builder;

@Builder
public record DonoDto(String nome, String cpf, String email, String numeroTelefone) {
}
