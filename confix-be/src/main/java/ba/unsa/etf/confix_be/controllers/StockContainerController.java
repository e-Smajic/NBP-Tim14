package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.StockContainerEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.StockContainerInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.StockContainerSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.StockContainerUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.StockContainerResponseDto;
import ba.unsa.etf.confix_be.services.StockContainerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/stock-container")
@Tag(name = "stock-containers", description = "Stock containers controller")
@RequiredArgsConstructor
public class StockContainerController implements BaseCRUDController<StockContainerEntity, StockContainerResponseDto, StockContainerSearchRequestDto, StockContainerInsertRequestDto, StockContainerUpdateRequestDto, Long> {
    private final StockContainerService service;
}
