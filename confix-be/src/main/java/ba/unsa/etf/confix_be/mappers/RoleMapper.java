package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.RoleEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.RoleInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.RoleUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.RoleResponseDto;
import org.mapstruct.Mapper;

/**
 * Mapper for {@link RoleEntity} and {@link RoleResponseDto}.
 */
@Mapper(componentModel = "spring")
public interface RoleMapper
        extends BaseCRUDMapper<RoleEntity, RoleResponseDto, RoleInsertRequestDto, RoleUpdateRequestDto> {
}
