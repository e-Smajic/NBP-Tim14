package ba.unsa.etf.confix_be.entities;

import ba.unsa.etf.confix_be.core.entities.AutoIdBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    @Column(name = "inspection_date")
    private LocalDate inspectionDate;

    @Column(name = "inspector_name")
    private String inspectorName;

    @Column(name = "notes")
    private String notes;

    @Column(name = "condition")
    private String condition;
}
