package projeto.backend.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Tecnico extends Pessoa implements Serializable {

}