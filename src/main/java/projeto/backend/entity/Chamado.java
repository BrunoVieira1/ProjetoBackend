package projeto.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import projeto.backend.enums.PrioridadeEnum;
import projeto.backend.enums.StatusEnum;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private LocalDate dataAbertura = LocalDate.now();

    private LocalDate dataFechamento;

    @NotNull
    private PrioridadeEnum prioridade;

    @NotNull
    private StatusEnum status;

    @NotNull
    private String titulo;

    @NotNull
    private String observacoes;

}