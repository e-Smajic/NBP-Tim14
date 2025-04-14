package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.InspectionEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.InspectionInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.InspectionUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.InspectionResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InspectionMapper extends BaseCRUDMapper<InspectionEntity, InspectionResponseDto, InspectionInsertRequestDto, InspectionUpdateRequestDto> {
}
