package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.ReportEntity;
import ba.unsa.etf.confix_be.mappers.ReportMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.ReportInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.ReportSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.ReportUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.ReportResponseDto;
import ba.unsa.etf.confix_be.repositories.ReportRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class ReportService implements BaseCRUDService<ReportEntity, ReportResponseDto, ReportSearchRequestDto, ReportInsertRequestDto, ReportUpdateRequestDto, Long> {
    private final ReportRepository repository;
    private final ReportMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<ReportEntity> getEntityClass() {
        return ReportEntity.class;
    }
}
