package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link UserEntity}.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
