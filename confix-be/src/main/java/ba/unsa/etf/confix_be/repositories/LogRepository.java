package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.LogEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link LogEntity}.
 */
public interface LogRepository extends CrudRepository<LogEntity, Long> {
}
