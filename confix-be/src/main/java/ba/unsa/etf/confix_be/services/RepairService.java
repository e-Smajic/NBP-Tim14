package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.RepairEntity;
import ba.unsa.etf.confix_be.mappers.RepairMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.RepairInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.RepairSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.RepairUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.RepairResponseDto;
import ba.unsa.etf.confix_be.repositories.RepairRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class RepairService implements BaseCRUDService<RepairEntity, RepairResponseDto, RepairSearchRequestDto, RepairInsertRequestDto, RepairUpdateRequestDto, Long> {
    private final RepairRepository repository;
    private final RepairMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<RepairEntity> getEntityClass() {
        return RepairEntity.class;
    }
}
