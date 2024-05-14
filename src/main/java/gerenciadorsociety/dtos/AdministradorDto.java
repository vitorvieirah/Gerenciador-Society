package gerenciadorsociety.dtos;

import lombok.Builder;

@Builder
public record AdministradorDto(Long id, String nome, String email, String cpf, String numeroTelefone) {
}
