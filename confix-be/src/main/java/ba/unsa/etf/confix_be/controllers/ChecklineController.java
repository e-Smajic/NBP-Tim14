package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.ChecklineEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.ChecklineInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.ChecklineSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.ChecklineUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.ChecklineResponseDto;
import ba.unsa.etf.confix_be.services.ChecklineService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/checklines")
@Tag(name = "checklines", description = "Checklines controller")
@RequiredArgsConstructor
public class ChecklineController implements BaseCRUDController<ChecklineEntity, ChecklineResponseDto, ChecklineSearchRequestDto, ChecklineInsertRequestDto, ChecklineUpdateRequestDto, Long> {
    private final ChecklineService service;
}
