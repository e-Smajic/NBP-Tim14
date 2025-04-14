package ba.unsa.etf.confix_be.mappers;

import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.entities.ReportEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.ReportInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.ReportUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.ReportResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportMapper extends BaseCRUDMapper<ReportEntity, ReportResponseDto, ReportInsertRequestDto, ReportUpdateRequestDto> {
}
