package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.ComponentEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.ComponentInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.ComponentUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.ComponentResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComponentMapper extends BaseCRUDMapper<ComponentEntity, ComponentResponseDto, ComponentInsertRequestDto, ComponentUpdateRequestDto> {
}
