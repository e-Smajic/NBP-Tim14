package ba.unsa.etf.confix_be.entities;

import ba.unsa.etf.confix_be.core.entities.AutoIdBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "materials")
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MaterialEntity extends AutoIdBaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "unit")
    private String unit;

    @Column(name = "cost_per_unit")
    private Double costPerUnit;

    @Column(name = "description")
    private String description;
}
