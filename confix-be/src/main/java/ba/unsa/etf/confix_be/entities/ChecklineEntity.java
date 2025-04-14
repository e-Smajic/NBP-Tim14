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
@Table(name = "checklines")
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ChecklineEntity extends AutoIdBaseEntity {
    @Column(name = "report_id")
    private Long reportId;

    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "component_id")
    private Long componentId;

    @Column(name = "damage_id")
    private Long damageId;

    @Column(name = "repair_id")
    private Long repairId;

    @Column(name = "material_id")
    private Long materialId;

    @Column(name = "length")
    private Double length;

    @Column(name = "width")
    private Double width;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "is_repaired")
    private Boolean isRepaired;
}
