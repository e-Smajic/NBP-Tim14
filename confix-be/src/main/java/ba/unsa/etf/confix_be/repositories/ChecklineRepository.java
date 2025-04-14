package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.ChecklineEntity;
import org.springframework.data.repository.CrudRepository;

public interface ChecklineRepository extends CrudRepository<ChecklineEntity, Long> {
}
