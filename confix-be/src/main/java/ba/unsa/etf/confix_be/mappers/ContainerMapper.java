package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.ContainerEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.ContainerInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.ContainerUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.ContainerResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContainerMapper extends BaseCRUDMapper<ContainerEntity, ContainerResponseDto, ContainerInsertRequestDto, ContainerUpdateRequestDto> {
}
