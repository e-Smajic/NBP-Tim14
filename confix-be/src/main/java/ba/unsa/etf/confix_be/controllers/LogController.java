package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.LogEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.LogInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.LogSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.LogUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.LogResponseDto;
import ba.unsa.etf.confix_be.services.LogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/logs")
@Tag(name = "logs", description = "Logs controller")
@RequiredArgsConstructor
public class LogController implements BaseCRUDController<LogEntity, LogResponseDto, LogSearchRequestDto, LogInsertRequestDto, LogUpdateRequestDto, Long> {
    private final LogService service;
}
