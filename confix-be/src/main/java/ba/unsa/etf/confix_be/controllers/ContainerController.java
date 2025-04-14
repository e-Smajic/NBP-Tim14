package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.ContainerEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.ContainerInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.ContainerSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.ContainerUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.ContainerResponseDto;
import ba.unsa.etf.confix_be.services.ContainerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/containers")
@Tag(name = "containers", description = "Containers controller")
@RequiredArgsConstructor
public class ContainerController implements BaseCRUDController<ContainerEntity, ContainerResponseDto, ContainerSearchRequestDto, ContainerInsertRequestDto, ContainerUpdateRequestDto, Long> {
    private final ContainerService service;
}
