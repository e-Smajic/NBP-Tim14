package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.entities.RoleEntity;
import ba.unsa.etf.confix_be.repositories.RoleRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
@RequiredArgsConstructor
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public List<RoleEntity> getAllRoles() {
        return repository.findAll();
    }

    public RoleEntity createRole(String name) {
        RoleEntity newRole = new RoleEntity();
        newRole.setName(name);
        return repository.save(newRole);
    }

    public void deleteRoleWithId(Long id) {
        repository.deleteById(id);
    }
}
