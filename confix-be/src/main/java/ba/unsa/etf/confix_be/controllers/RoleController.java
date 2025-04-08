package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.entities.RoleEntity;
import ba.unsa.etf.confix_be.services.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@RestController
@RequestMapping("/api/roles")
@Tag(name = "roles", description = "Roles controller")
@RequiredArgsConstructor
public class RoleController {
    @Autowired
    private RoleService service;

    @GetMapping("/")
    public List<RoleEntity> getAllRoles() {
        return service.getAllRoles();
    }

    @PostMapping("/")
    public ResponseEntity<?> createRole(@RequestBody String name) {
        if (name.isBlank() || name.length() > 50)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid role name");

        return ResponseEntity.ok(service.createRole(name));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteRole(@RequestBody Long id) {
        service.deleteRoleWithId(id);
        return ResponseEntity.ok("Role deleted");
    }
}
