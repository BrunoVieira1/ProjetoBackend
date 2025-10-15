package projeto.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import projeto.backend.dto.ClienteRequestDto;
import projeto.backend.dto.ClienteResponseDto;
import projeto.backend.entity.Cliente;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "perfilEnum", expression = "java(projeto.backend.enums.PerfilEnum.CLIENTE)")
    @Mapping(target = "dataCriacao", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "id", ignore = true)
    Cliente toEntity(ClienteRequestDto dto);

    ClienteResponseDto toResponseDto(Cliente cliente);

    List<ClienteResponseDto> toResponseDtoList(List<Cliente> clientes);
}