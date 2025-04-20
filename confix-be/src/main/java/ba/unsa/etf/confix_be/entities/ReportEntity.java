package ba.unsa.etf.confix_be.entities;

import ba.unsa.etf.confix_be.core.entities.AutoIdBaseEntity;
import ba.unsa.etf.confix_be.enums.ReportState;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reports")
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ReportEntity extends AutoIdBaseEntity {
    @Column(name = "inspection_id")
    private Long inspectionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inspection_id", insertable = false, updatable = false)
    private InspectionEntity inspection;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "repaired_by")
    private String repairedBy;

    @Column(name = "repair_completion_date")
    private LocalDate repairCompletionDate;

    @Column(name = "state")
    private ReportState state;

    @Column(name = "comments")
    private String comments;

    @Column(name = "created_by")
    private Long createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", insertable = false, updatable = false)
    private UserEntity createdByUser; // createdBy property should ideally be renamed to createdByID, so that this entity can be createdBy.

    @Column(name = "repaired_by_id")
    private Long repairedById;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repaired_by_id", insertable = false, updatable = false)
    private UserEntity repairedByUser; // repairedBy is string, hence repairedByUser
}
