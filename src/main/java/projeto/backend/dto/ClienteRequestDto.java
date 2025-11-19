package projeto.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;


@Getter
@Schema(description = "DTO para registrar a entrada de um novo Cliente")
public class ClienteRequestDto {

    @NotBlank(message = "O campo NOME é obrigatório!")
    private final String nome;

    @NotBlank(message = "O campo CPF é obrigatório!")
    private final String cpf;

    @Email
    @NotBlank(message = "O campo EMAIL é obrigatório!")
    private final String email;

    @NotBlank(message = "O campo SENHA é obrigatório!")
    private final String senha;

    public ClienteRequestDto(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
}