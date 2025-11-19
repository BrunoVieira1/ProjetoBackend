package projeto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.backend.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByNome(String nome);
}
