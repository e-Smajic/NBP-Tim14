package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.StockContainerEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link StockContainerEntity}.
 */
public interface StockContainerRepository extends CrudRepository<StockContainerEntity, Long> {
}
