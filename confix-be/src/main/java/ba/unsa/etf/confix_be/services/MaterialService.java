package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.MaterialEntity;
import ba.unsa.etf.confix_be.mappers.MaterialMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.MaterialInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.MaterialSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.MaterialUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.MaterialResponseDto;
import ba.unsa.etf.confix_be.repositories.MaterialRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class MaterialService implements BaseCRUDService<MaterialEntity, MaterialResponseDto, MaterialSearchRequestDto, MaterialInsertRequestDto, MaterialUpdateRequestDto, Long> {
    private final MaterialRepository repository;
    private final MaterialMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<MaterialEntity> getEntityClass() {
        return MaterialEntity.class;
    }
}
