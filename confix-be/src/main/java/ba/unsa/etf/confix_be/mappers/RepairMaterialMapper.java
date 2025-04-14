package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.RepairMaterialEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.RepairMaterialInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.RepairMaterialUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.RepairMaterialResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RepairMaterialMapper extends BaseCRUDMapper<RepairMaterialEntity, RepairMaterialResponseDto, RepairMaterialInsertRequestDto, RepairMaterialUpdateRequestDto> {
}
