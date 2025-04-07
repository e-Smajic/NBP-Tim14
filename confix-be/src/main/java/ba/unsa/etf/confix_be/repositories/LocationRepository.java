package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.LocationEntity;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<LocationEntity, Long> {
}
