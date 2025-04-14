package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.LogEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.LogInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.LogUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.LogResponseDto;
import org.mapstruct.Mapper;

/**
 * Mapper for {@link LogEntity} and {@link LogResponseDto}.
 */
@Mapper(componentModel = "spring")
public interface LogMapper extends BaseCRUDMapper<LogEntity, LogResponseDto, LogInsertRequestDto, LogUpdateRequestDto> {
}
