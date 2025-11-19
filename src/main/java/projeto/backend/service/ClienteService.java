package projeto.backend.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.backend.dto.ClienteRequestDto;
import projeto.backend.entity.Cliente;
import projeto.backend.mapper.ClienteMapper;
import projeto.backend.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteMapper mapper;

    public Cliente criar(ClienteRequestDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado! Id: " + id));
    }

    public Cliente update(Integer id, ClienteRequestDto dto) {
        Cliente clienteAntigo = findById(id);
        Cliente clienteNovo = mapper.toEntity(dto);

        clienteNovo.setId(id);
        clienteNovo.setDataCriacao(clienteAntigo.getDataCriacao());

        return repository.save(clienteNovo);
    }

    public void delete(Integer id) {
        Cliente cliente = findById(id);
        repository.delete(cliente);
    }
}