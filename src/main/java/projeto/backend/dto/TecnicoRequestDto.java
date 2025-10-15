package projeto.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Schema(description = "DTO para registrar a entrada de um novo Técnico")
public class TecnicoRequestDto {

    @NotBlank(message = "O campo NOME é obrigatório!")
    private final String nome;

    @NotNull(message = "O campo CPF é obrigatório!")
    private final Integer cpf;

    @Email
    @NotBlank(message = "O campo EMAIL é obrigatório!")
    private final String email;

    @NotBlank(message = "O campo SENHA é obrigatório!")
    private final String senha;

    public TecnicoRequestDto(String nome, Integer cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
}