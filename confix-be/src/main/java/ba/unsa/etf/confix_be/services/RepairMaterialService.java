package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.RepairMaterialEntity;
import ba.unsa.etf.confix_be.mappers.RepairMaterialMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.RepairMaterialInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.RepairMaterialSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.RepairMaterialUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.RepairMaterialResponseDto;
import ba.unsa.etf.confix_be.repositories.RepairMaterialRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@RequiredArgsConstructor
@Service
public class RepairMaterialService implements BaseCRUDService<RepairMaterialEntity, RepairMaterialResponseDto, RepairMaterialSearchRequestDto, RepairMaterialInsertRequestDto, RepairMaterialUpdateRequestDto, Long> {
    private final RepairMaterialRepository repository;
    private final RepairMaterialMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<RepairMaterialEntity> getEntityClass() {
        return RepairMaterialEntity.class;
    }
}
