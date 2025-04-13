package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.StockContainerEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.StockContainerInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.StockContainerUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.StockContainerResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockContainerMapper extends BaseCRUDMapper<StockContainerEntity, StockContainerResponseDto, StockContainerInsertRequestDto, StockContainerUpdateRequestDto> {
}
