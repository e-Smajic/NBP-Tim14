package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.RepairEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link RepairEntity}.
 */
public interface RepairRepository extends CrudRepository<RepairEntity, Long> {
}
