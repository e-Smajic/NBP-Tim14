package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.MaterialEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.MaterialInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.MaterialUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.MaterialResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialMapper extends BaseCRUDMapper<MaterialEntity, MaterialResponseDto, MaterialInsertRequestDto, MaterialUpdateRequestDto> {
}
