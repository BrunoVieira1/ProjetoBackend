package projeto.backend.resource;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.backend.dto.ClienteRequestDto;
import projeto.backend.dto.ClienteResponseDto;
import projeto.backend.entity.Cliente;
import projeto.backend.mapper.ClienteMapper;
import projeto.backend.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
@Tag(name = "Cliente")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponseDto> criar(@Valid @RequestBody ClienteRequestDto dto) {
        Cliente cliente = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponseDto(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> findAll() {
        List<Cliente> list = service.findAll();
        return ResponseEntity.ok().body(mapper.toResponseDtoList(list));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDto> findById(@PathVariable Integer id) {
        Cliente cliente = service.findById(id);
        return ResponseEntity.ok().body(mapper.toResponseDto(cliente));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteResponseDto> update(@PathVariable Integer id, @Valid @RequestBody ClienteRequestDto dto) {
        Cliente cliente = service.update(id, dto);
        return ResponseEntity.ok().body(mapper.toResponseDto(cliente));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}