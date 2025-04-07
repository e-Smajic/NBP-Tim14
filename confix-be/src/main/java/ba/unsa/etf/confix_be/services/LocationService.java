package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.LocationEntity;
import ba.unsa.etf.confix_be.mappers.LocationMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.LocationInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.LocationSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.LocationUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.LocationResponseDto;
import ba.unsa.etf.confix_be.repositories.LocationRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class LocationService implements BaseCRUDService<LocationEntity, LocationResponseDto, LocationSearchRequestDto, LocationInsertRequestDto, LocationUpdateRequestDto, Long> {
    private final LocationRepository repository;
    private final LocationMapper mapper;
    private final EntityManager entityManager;


    @Override
    public Class<LocationEntity> getEntityClass() {
        return LocationEntity.class;
    }
}
