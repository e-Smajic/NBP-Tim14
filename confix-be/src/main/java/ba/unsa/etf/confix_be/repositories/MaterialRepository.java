package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.MaterialEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link MaterialEntity}.
 */
public interface MaterialRepository extends CrudRepository<MaterialEntity, Long> {
}
