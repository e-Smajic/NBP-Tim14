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
@Table(name = "repair_materials")
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RepairMaterialEntity extends AutoIdBaseEntity {
    @Column(name = "checkline_id")
    private Long checklineId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checkline_id", insertable = false, updatable = false)
    private ChecklineEntity checkline;

    @Column(name = "material_id")
    private Long materialId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "material_id", insertable = false, updatable = false)
    private MaterialEntity material;

    @Column(name = "quantity_used")
    private Integer quantityUsed;

    @Column(name = "cost")
    private Double cost;
}
