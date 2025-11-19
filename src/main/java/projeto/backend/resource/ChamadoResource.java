package projeto.backend.resource;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.backend.dto.ChamadoRequestDto;
import projeto.backend.dto.ChamadoResponseDto;
import projeto.backend.entity.Chamado;
import projeto.backend.mapper.ChamadoMapper;
import projeto.backend.service.ChamadoService;

import java.util.List;

@RestController
@RequestMapping(value = "/chamados")
@Tag(name = "Chamado")
public class ChamadoResource {

    @Autowired
    private ChamadoService service;

    @Autowired
    private ChamadoMapper mapper;

    @PostMapping
    public ResponseEntity<ChamadoResponseDto> criar(@Valid @RequestBody ChamadoRequestDto dto) {
        Chamado chamado = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDto(chamado));
    }

    @GetMapping
    public ResponseEntity<List<ChamadoResponseDto>> findAll() {
        List<Chamado> list = service.findAll();
        return ResponseEntity.ok().body(mapper.toResponseDtoList(list));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ChamadoResponseDto> findById(@PathVariable Integer id) {
        Chamado chamado = service.findById(id);
        return ResponseEntity.ok().body(mapper.toResponseDto(chamado));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ChamadoResponseDto> update(@PathVariable Integer id, @Valid @RequestBody ChamadoRequestDto dto) {
        Chamado chamado = service.update(id, dto);
        return ResponseEntity.ok().body(mapper.toResponseDto(chamado));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}