package projeto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.backend.entity.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
    Chamado findByTitulo(String titulo);
}
