package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.LogEntity;
import ba.unsa.etf.confix_be.mappers.LogMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.LogInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.LogSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.LogUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.LogResponseDto;
import ba.unsa.etf.confix_be.repositories.LogRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class LogService implements BaseCRUDService<LogEntity, LogResponseDto, LogSearchRequestDto, LogInsertRequestDto, LogUpdateRequestDto, Long> {
    private final LogRepository repository;
    private final LogMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<LogEntity> getEntityClass() {
        return LogEntity.class;
    }
}
