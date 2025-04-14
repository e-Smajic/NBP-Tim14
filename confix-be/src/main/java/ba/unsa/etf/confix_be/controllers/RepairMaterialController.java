package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.RepairMaterialEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.RepairMaterialInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.RepairMaterialSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.RepairMaterialUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.RepairMaterialResponseDto;
import ba.unsa.etf.confix_be.services.RepairMaterialService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/repair-materials")
@Tag(name = "repair-materials", description = "Repair materials controller")
@RequiredArgsConstructor
public class RepairMaterialController implements BaseCRUDController<RepairMaterialEntity, RepairMaterialResponseDto, RepairMaterialSearchRequestDto, RepairMaterialInsertRequestDto, RepairMaterialUpdateRequestDto, Long> {
    private final RepairMaterialService service;
}
