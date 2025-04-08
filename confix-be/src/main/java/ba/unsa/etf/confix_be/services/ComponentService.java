package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.ComponentEntity;
import ba.unsa.etf.confix_be.mappers.ComponentMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.ComponentInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.ComponentSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.ComponentUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.ComponentResponseDto;
import ba.unsa.etf.confix_be.repositories.ComponentRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class ComponentService implements BaseCRUDService<ComponentEntity, ComponentResponseDto, ComponentSearchRequestDto, ComponentInsertRequestDto, ComponentUpdateRequestDto, Long> {
    private final ComponentRepository repository;
    private final ComponentMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<ComponentEntity> getEntityClass() {
        return ComponentEntity.class;
    }
}
