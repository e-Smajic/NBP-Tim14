package ba.unsa.etf.confix_be.entities;

import ba.unsa.etf.confix_be.core.entities.AutoIdBaseEntity;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "inspections")
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class InspectionEntity extends AutoIdBaseEntity {
    @Column(name = "stock_container_id")
    private Long stockContainerId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_container_id", insertable = false, updatable = false)
    private StockContainerEntity stockContainer;

    @Column(name = "inspection_date")
    private LocalDate inspectionDate;

    @Column(name = "inspector_name")
    private String inspectorName;

    @Column(name = "notes")
    private String notes;

    @Column(name = "condition")
    private String condition;
}
