package projeto.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import projeto.backend.dto.ChamadoRequestDto;
import projeto.backend.dto.ChamadoResponseDto;
import projeto.backend.entity.Chamado;
import projeto.backend.entity.Cliente;
import projeto.backend.entity.Tecnico;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tecnico", source = "tecnicoEntidade")
    @Mapping(target = "cliente", source = "clienteEntidade")
    @Mapping(target = "dataAbertura", expression = "java(java.time.LocalDate.now())")
    Chamado toEntity(ChamadoRequestDto dto, Cliente clienteEntidade, Tecnico tecnicoEntidade);



    default ChamadoResponseDto toResponseDto(Chamado chamado) {
        return new ChamadoResponseDto(chamado);
    }

    default List<ChamadoResponseDto> toResponseDtoList(List<Chamado> chamados) {
        return chamados.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }
}