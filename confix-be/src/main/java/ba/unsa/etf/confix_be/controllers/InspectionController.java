package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.InspectionEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.InspectionInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.InspectionSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.InspectionUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.InspectionResponseDto;
import ba.unsa.etf.confix_be.services.InspectionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/inspections")
@Tag(name = "inspections", description = "Inspections controller")
@RequiredArgsConstructor
public class InspectionController implements BaseCRUDController<InspectionEntity, InspectionResponseDto, InspectionSearchRequestDto, InspectionInsertRequestDto, InspectionUpdateRequestDto, Long> {
    private final InspectionService service;
}
