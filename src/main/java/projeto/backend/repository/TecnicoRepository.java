package projeto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.backend.entity.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
    Tecnico findByNome(String nome);
}
