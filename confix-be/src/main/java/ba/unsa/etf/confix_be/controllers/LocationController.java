package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.LocationEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.LocationInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.LocationSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.LocationUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.LocationResponseDto;
import ba.unsa.etf.confix_be.services.LocationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/locations")
@Tag(name = "locations", description = "Locations controller")
@RequiredArgsConstructor
public class LocationController implements BaseCRUDController<LocationEntity, LocationResponseDto, LocationSearchRequestDto, LocationInsertRequestDto, LocationUpdateRequestDto, Long> {
    private final LocationService service;
}
