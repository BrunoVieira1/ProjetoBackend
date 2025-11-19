package projeto.backend.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.backend.dto.TecnicoRequestDto;
import projeto.backend.entity.Tecnico;
import projeto.backend.mapper.TecnicoMapper;
import projeto.backend.repository.TecnicoRepository;

import java.util.List;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    @Autowired
    private TecnicoMapper mapper;

    public Tecnico criar(TecnicoRequestDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Técnico não encontrado! Id: " + id));
    }

    public Tecnico update(Integer id, TecnicoRequestDto dto) {
        Tecnico tecnicoAntigo = findById(id);


        Tecnico tecnicoNovo = mapper.toEntity(dto);


        tecnicoNovo.setId(id);
        tecnicoNovo.setDataCriacao(tecnicoAntigo.getDataCriacao());

        return repository.save(tecnicoNovo);
    }

    public void delete(Integer id) {
        Tecnico tecnico = findById(id);
        repository.delete(tecnico);
    }
}