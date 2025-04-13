package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.StockContainerEntity;
import ba.unsa.etf.confix_be.mappers.StockContainerMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.StockContainerInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.StockContainerSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.StockContainerUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.StockContainerResponseDto;
import ba.unsa.etf.confix_be.repositories.StockContainerRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class StockContainerService implements BaseCRUDService<StockContainerEntity, StockContainerResponseDto, StockContainerSearchRequestDto, StockContainerInsertRequestDto, StockContainerUpdateRequestDto, Long> {
    private final StockContainerRepository repository;
    private final StockContainerMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<StockContainerEntity> getEntityClass() {
        return StockContainerEntity.class;
    }
}
