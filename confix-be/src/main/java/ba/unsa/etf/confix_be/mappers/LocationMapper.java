package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.LocationEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.LocationInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.LocationUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.LocationResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper extends BaseCRUDMapper<LocationEntity, LocationResponseDto, LocationInsertRequestDto, LocationUpdateRequestDto> {
}
