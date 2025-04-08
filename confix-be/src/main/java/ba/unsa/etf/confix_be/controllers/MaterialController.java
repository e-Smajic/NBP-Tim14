package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.MaterialEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.MaterialInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.MaterialSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.MaterialUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.MaterialResponseDto;
import ba.unsa.etf.confix_be.services.MaterialService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/materials")
@Tag(name = "materials", description = "Materials controller")
@RequiredArgsConstructor
public class MaterialController implements BaseCRUDController<MaterialEntity, MaterialResponseDto, MaterialSearchRequestDto, MaterialInsertRequestDto, MaterialUpdateRequestDto, Long> {
    private final MaterialService service;
}
