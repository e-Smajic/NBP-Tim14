package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.ChecklineEntity;
import ba.unsa.etf.confix_be.mappers.ChecklineMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.ChecklineInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.ChecklineSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.ChecklineUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.ChecklineResponseDto;
import ba.unsa.etf.confix_be.repositories.ChecklineRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class ChecklineService implements
        BaseCRUDService<ChecklineEntity, ChecklineResponseDto, ChecklineSearchRequestDto, ChecklineInsertRequestDto, ChecklineUpdateRequestDto, Long> {
    private final ChecklineRepository repository;
    private final ChecklineMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<ChecklineEntity> getEntityClass() {
        return ChecklineEntity.class;
    }
}
