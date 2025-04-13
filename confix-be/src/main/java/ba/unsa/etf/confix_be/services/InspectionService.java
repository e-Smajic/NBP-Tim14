package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.InspectionEntity;
import ba.unsa.etf.confix_be.mappers.InspectionMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.InspectionInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.InspectionSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.InspectionUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.InspectionResponseDto;
import ba.unsa.etf.confix_be.repositories.InspectionRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class InspectionService implements BaseCRUDService<InspectionEntity, InspectionResponseDto, InspectionSearchRequestDto, InspectionInsertRequestDto, InspectionUpdateRequestDto, Long> {
    private final InspectionRepository repository;
    private final InspectionMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<InspectionEntity> getEntityClass() {
        return InspectionEntity.class;
    }
}
