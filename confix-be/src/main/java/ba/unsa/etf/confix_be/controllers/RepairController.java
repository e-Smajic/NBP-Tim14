package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.RepairEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.RepairInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.RepairSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.RepairUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.RepairResponseDto;
import ba.unsa.etf.confix_be.services.RepairService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/repairs")
@Tag(name = "repairs", description = "Repairs controller")
@RequiredArgsConstructor
public class RepairController implements BaseCRUDController<RepairEntity, RepairResponseDto, RepairSearchRequestDto, RepairInsertRequestDto, RepairUpdateRequestDto, Long> {
    private final RepairService service;
}
