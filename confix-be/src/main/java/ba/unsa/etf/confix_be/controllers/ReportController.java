package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.ReportEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.ReportInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.ReportSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.ReportUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.ReportResponseDto;
import ba.unsa.etf.confix_be.services.ReportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/reports")
@Tag(name = "reports", description = "Reports controller")
@RequiredArgsConstructor
public class ReportController implements BaseCRUDController<ReportEntity, ReportResponseDto, ReportSearchRequestDto, ReportInsertRequestDto, ReportUpdateRequestDto, Long> {
    private final ReportService service;
}
