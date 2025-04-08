package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.RepairEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.RepairInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.RepairUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.RepairResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RepairMapper extends BaseCRUDMapper<RepairEntity, RepairResponseDto, RepairInsertRequestDto, RepairUpdateRequestDto> {
}
