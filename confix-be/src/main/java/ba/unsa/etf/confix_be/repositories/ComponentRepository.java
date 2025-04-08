package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.ComponentEntity;
import org.springframework.data.repository.CrudRepository;

public interface ComponentRepository extends CrudRepository<ComponentEntity, Long> {
}
