package ba.unsa.etf.confix_be.repositories;

import ba.unsa.etf.confix_be.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link RoleEntity}.
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
