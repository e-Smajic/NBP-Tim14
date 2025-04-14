package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.ContainerEntity;
import ba.unsa.etf.confix_be.mappers.ContainerMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.ContainerInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.ContainerSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.ContainerUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.ContainerResponseDto;
import ba.unsa.etf.confix_be.repositories.ContainerRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class ContainerService implements BaseCRUDService<ContainerEntity, ContainerResponseDto, ContainerSearchRequestDto, ContainerInsertRequestDto, ContainerUpdateRequestDto, Long> {
    private final ContainerRepository repository;
    private final ContainerMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<ContainerEntity> getEntityClass() {
        return ContainerEntity.class;
    }
}
