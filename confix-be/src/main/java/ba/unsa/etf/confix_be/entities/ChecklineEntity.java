package ba.unsa.etf.confix_be.entities;

import ba.unsa.etf.confix_be.core.entities.AutoIdBaseEntity;
import jakarta.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id", insertable = false, updatable = false)
    private ReportEntity report;

    @Column(name = "location_id")
    private Long locationId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    private LocationEntity location;

    @Column(name = "component_id")
    private Long componentId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "component_id", insertable = false, updatable = false)
    private ComponentEntity component;

    @Column(name = "damage_id")
    private Long damageId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "damage_id", insertable = false, updatable = false)
    private DamageEntity damage;

    @Column(name = "repair_id")
    private Long repairId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repair_id", insertable = false, updatable = false)
    private RepairEntity repair;

    @Column(name = "material_id")
    private Long materialId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "material_id", insertable = false, updatable = false)
    private MaterialEntity material;

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
