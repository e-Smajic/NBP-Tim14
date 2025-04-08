package ba.unsa.etf.confix_be.entities;

import ba.unsa.etf.confix_be.core.entities.AutoIdBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "components")
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ComponentEntity extends AutoIdBaseEntity {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
