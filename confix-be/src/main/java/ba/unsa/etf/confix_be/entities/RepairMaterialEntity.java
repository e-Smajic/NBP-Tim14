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
@Table(name = "repair_materials")
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RepairMaterialEntity extends AutoIdBaseEntity {
    @Column(name = "checkline_id")
    private Long checklineId;

    @Column(name = "material_id")
    private Long materialId;

    @Column(name = "quantity_used")
    private Integer quantityUsed;

    @Column(name = "cost")
    private Double cost;
}
