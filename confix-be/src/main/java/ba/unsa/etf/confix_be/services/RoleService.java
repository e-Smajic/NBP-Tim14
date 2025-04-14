package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.RoleEntity;
import ba.unsa.etf.confix_be.mappers.RoleMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.RoleInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.RoleSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.RoleUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.RoleResponseDto;
import ba.unsa.etf.confix_be.repositories.RoleRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class RoleService implements BaseCRUDService<RoleEntity, RoleResponseDto, RoleSearchRequestDto, RoleInsertRequestDto, RoleUpdateRequestDto, Long> {
    private final RoleRepository repository;
    private final RoleMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<RoleEntity> getEntityClass() {
        return RoleEntity.class;
    }
}
