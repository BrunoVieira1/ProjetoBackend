package projeto.backend.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import projeto.backend.enums.PerfilEnum;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotNull
    protected String nome;

    @NotNull
    protected Integer cpf;

    @NotNull
    protected String email;

    @NotNull
    protected String senha;

    @NotNull
    protected PerfilEnum perfilEnum;

    @NotNull
    protected Date dataCriacao;

}
