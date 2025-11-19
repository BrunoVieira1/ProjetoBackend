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
@EqualsAndHashCode(of = "id")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataAbertura = LocalDate.now();

    private LocalDate dataFechamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PrioridadeEnum prioridade;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @NotNull
    private String titulo;

    @NotNull
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}