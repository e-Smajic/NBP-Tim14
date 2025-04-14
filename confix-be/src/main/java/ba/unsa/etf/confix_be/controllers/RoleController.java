package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.RoleEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.RoleInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.RoleSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.RoleUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.RoleResponseDto;
import ba.unsa.etf.confix_be.services.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Getter
@RestController
@RequestMapping("/api/roles")
@Tag(name = "roles", description = "Roles controller")
@RequiredArgsConstructor
public class RoleController implements BaseCRUDController<RoleEntity, RoleResponseDto, RoleSearchRequestDto, RoleInsertRequestDto, RoleUpdateRequestDto, Long> {
    private final RoleService service;
}
