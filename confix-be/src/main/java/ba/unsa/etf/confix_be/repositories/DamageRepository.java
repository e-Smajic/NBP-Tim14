package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.DamageEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link DamageEntity}.
 */
public interface DamageRepository extends CrudRepository<DamageEntity, Long> {
}
