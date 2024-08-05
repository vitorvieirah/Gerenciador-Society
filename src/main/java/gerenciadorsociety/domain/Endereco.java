package gerenciadorsociety.domain;

import lombok.Builder;

@Builder
public record Endereco (String rua, Integer numero, String bairro, String cep){}
