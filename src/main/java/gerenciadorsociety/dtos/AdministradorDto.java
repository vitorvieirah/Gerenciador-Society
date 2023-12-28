package gerenciadorsociety.dtos;

import lombok.Builder;

@Builder
public record AdministradorDto(String nome, String email, String cpf, String numeroTelefone) {
}
