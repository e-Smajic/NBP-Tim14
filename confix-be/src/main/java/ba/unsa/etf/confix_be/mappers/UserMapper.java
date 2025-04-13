package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.UserEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.UserInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.UserUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.UserResponseDto;
import org.mapstruct.Mapper;

/**
 * Mapper for {@link UserEntity} and {@link UserResponseDto}.
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseCRUDMapper<UserEntity, UserResponseDto, UserInsertRequestDto, UserUpdateRequestDto> {
}
