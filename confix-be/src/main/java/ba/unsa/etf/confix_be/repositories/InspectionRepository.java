package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.InspectionEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link InspectionEntity}.
 */
public interface InspectionRepository extends CrudRepository<InspectionEntity, Long> {
}
