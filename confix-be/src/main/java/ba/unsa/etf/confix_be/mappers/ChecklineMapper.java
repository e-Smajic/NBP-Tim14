package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.ChecklineEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.ChecklineInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.ChecklineUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.ChecklineResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChecklineMapper extends BaseCRUDMapper<ChecklineEntity, ChecklineResponseDto, ChecklineInsertRequestDto, ChecklineUpdateRequestDto> {
}
