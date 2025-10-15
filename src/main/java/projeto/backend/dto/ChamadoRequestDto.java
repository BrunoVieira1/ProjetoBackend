package projeto.backend.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import projeto.backend.enums.PrioridadeEnum;
import projeto.backend.enums.StatusEnum;

@Getter
@Schema(description = "DTO para registrar a entrada de um novo Chamado")
public class ChamadoRequestDto {

    @NotBlank(message = "O campo TÍTULO é obrigatório!")
    private final String titulo;

    @NotBlank(message = "O campo OBSERVAÇÕES é obrigatório!")
    private final String observacoes;

    @NotNull(message = "O campo PRIORIDADE é obrigatório!")
    private final PrioridadeEnum prioridade;

    @NotNull(message = "O campo STATUS é obrigatório!")
    private final StatusEnum status;

    @NotNull(message = "O campo CLIENTE é obrigatório!")
    private final Integer cliente;

    @NotNull(message = "O campo TÉCNICO é obrigatório!")
    private final Integer tecnico;

    public ChamadoRequestDto(String titulo, String observacoes, PrioridadeEnum prioridade, StatusEnum status, Integer cliente, Integer tecnico) {
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.prioridade = prioridade;
        this.status = status;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }
}