package gerenciadorsociety.entrypoint.dtos.usuarios;

import gerenciadorsociety.domain.Endereco;

public record JogadorDto(Long id, String nome, String email, String numeroTelefone, String cpf, Endereco endereco) {
}
