package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.DamageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.StreamSupport;

/**
 * Repository for {@link DamageEntity}.
 */
public interface DamageRepository extends CrudRepository<DamageEntity, Long> {
}
