package projeto.backend.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.backend.dto.ChamadoRequestDto;
import projeto.backend.entity.Chamado;
import projeto.backend.entity.Cliente;
import projeto.backend.entity.Tecnico;
import projeto.backend.mapper.ChamadoMapper;
import projeto.backend.repository.ChamadoRepository;

import java.util.List;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    @Autowired
    private ChamadoMapper mapper;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TecnicoService tecnicoService;

    public Chamado criar(ChamadoRequestDto dto) {
        Cliente cliente = clienteService.findById(dto.getCliente());
        Tecnico tecnico = tecnicoService.findById(dto.getTecnico());

        Chamado chamado = mapper.toEntity(dto, cliente, tecnico);
        return repository.save(chamado);
    }

    public List<Chamado> findAll() {
        return repository.findAll();
    }

    public Chamado findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Chamado não encontrado! ID: " + id));
    }

    public Chamado update(Integer id, ChamadoRequestDto dto) {
        Chamado chamadoAntigo = findById(id);

        Cliente cliente = clienteService.findById(dto.getCliente());
        Tecnico tecnico = tecnicoService.findById(dto.getTecnico());

        Chamado chamadoNovo = mapper.toEntity(dto, cliente, tecnico);

        chamadoNovo.setId(id);
        chamadoNovo.setDataAbertura(chamadoAntigo.getDataAbertura());

        if(chamadoNovo.getDataFechamento() == null) {
            chamadoNovo.setDataFechamento(chamadoAntigo.getDataFechamento());
        }

        return repository.save(chamadoNovo);
    }

    public void delete(Integer id) {
        Chamado chamado = findById(id);
        repository.delete(chamado);
    }
}