package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.ComponentEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.ComponentInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.ComponentSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.ComponentUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.ComponentResponseDto;
import ba.unsa.etf.confix_be.services.ComponentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/components")
@Tag(name = "components", description = "Components controller")
@RequiredArgsConstructor
public class ComponentController implements BaseCRUDController<ComponentEntity, ComponentResponseDto, ComponentSearchRequestDto, ComponentInsertRequestDto, ComponentUpdateRequestDto, Long> {
    private final ComponentService service;
}
