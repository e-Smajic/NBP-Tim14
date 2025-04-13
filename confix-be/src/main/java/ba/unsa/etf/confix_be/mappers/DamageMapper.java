package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.DamageEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.DamageInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.DamageUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.DamageResponseDto;
import org.mapstruct.Mapper;

/**
 * Mapper for {@link DamageEntity} and {@link DamageResponseDto}.
 */
@Mapper(componentModel = "spring")
public interface DamageMapper extends BaseCRUDMapper<DamageEntity, DamageResponseDto, DamageInsertRequestDto, DamageUpdateRequestDto> {
}
