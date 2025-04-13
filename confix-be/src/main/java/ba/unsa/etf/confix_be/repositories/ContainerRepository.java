package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.ContainerEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link ContainerEntity}.
 */
public interface ContainerRepository extends CrudRepository<ContainerEntity, Long> {
}
