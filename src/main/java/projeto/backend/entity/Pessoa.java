package projeto.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import projeto.backend.enums.PerfilEnum;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public abstract class Pessoa implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotNull
    protected String nome;

    @NotNull
    @Column(unique = true)
    protected String cpf;

    @NotNull
    @Column(unique = true)
    protected String email;

    @NotNull
    protected String senha;

    @NotNull
    @Enumerated(EnumType.STRING)
    protected PerfilEnum perfilEnum;

    @Column(updatable = false)
    protected LocalDate dataCriacao;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDate.now();
    }
}