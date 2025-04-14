package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.RoleEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link RoleEntity}.
 */
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
