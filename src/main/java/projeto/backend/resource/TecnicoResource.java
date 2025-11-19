package projeto.backend.resource;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.backend.dto.TecnicoRequestDto;
import projeto.backend.dto.TecnicoResponseDto;
import projeto.backend.entity.Tecnico;
import projeto.backend.mapper.TecnicoMapper;
import projeto.backend.service.TecnicoService;

import java.util.List;

@RestController
@RequestMapping(value = "/tecnicos")
@Tag(name = "Tecnico")
public class TecnicoResource {

    @Autowired
    private TecnicoService service;

    @Autowired
    private TecnicoMapper mapper;

    @PostMapping
    public ResponseEntity<TecnicoResponseDto> criar(@Valid @RequestBody TecnicoRequestDto dto) {
        Tecnico tecnico = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDto(tecnico));
    }

    @GetMapping
    public ResponseEntity<List<TecnicoResponseDto>> findAll() {
        List<Tecnico> list = service.findAll();
        return ResponseEntity.ok().body(mapper.toResponseDtoList(list));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoResponseDto> findById(@PathVariable Integer id) {
        Tecnico tecnico = service.findById(id);
        return ResponseEntity.ok().body(mapper.toResponseDto(tecnico));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TecnicoResponseDto> update(@PathVariable Integer id, @Valid @RequestBody TecnicoRequestDto dto) {
        Tecnico tecnico = service.update(id, dto);
        return ResponseEntity.ok().body(mapper.toResponseDto(tecnico));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}