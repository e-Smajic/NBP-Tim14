package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.DamageEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.DamageInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.DamageUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.DamageResponseDto;
import ba.unsa.etf.confix_be.payloads.request.search.DamageSearchRequestDto;
import ba.unsa.etf.confix_be.services.DamageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/damages")
@Tag(name = "cedex", description = "Damage codes controller")
@RequiredArgsConstructor
public class DamageController implements BaseCRUDController<DamageEntity, DamageResponseDto, DamageSearchRequestDto, DamageInsertRequestDto, DamageUpdateRequestDto, Long> {
    private final DamageService service;
}
