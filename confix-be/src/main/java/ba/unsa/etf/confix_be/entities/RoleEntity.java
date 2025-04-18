package ba.unsa.etf.confix_be.entities;

import ba.unsa.etf.confix_be.core.entities.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "nbp_role", schema = "nbp")
public class RoleEntity extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR2(50)")
    private String name;
}
