package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.core.services.BaseService;
import ba.unsa.etf.confix_be.entities.DamageEntity;
import ba.unsa.etf.confix_be.mappers.DamageMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.DamageInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.DamageUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.DamageResponseDto;
import ba.unsa.etf.confix_be.payloads.request.search.DamageSearchRequestDto;
import ba.unsa.etf.confix_be.repositories.DamageRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service for {@link ba.unsa.etf.confix_be.entities.DamageEntity}.
 * Provides methods for CRUD operations.
 */
@Getter
@Service
@RequiredArgsConstructor
public class DamageService implements BaseCRUDService<DamageEntity, DamageResponseDto, DamageSearchRequestDto, DamageInsertRequestDto, DamageUpdateRequestDto, Long> {
    private final DamageRepository repository;
    private final DamageMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<DamageEntity> getEntityClass() {
        return DamageEntity.class;
    }
}
