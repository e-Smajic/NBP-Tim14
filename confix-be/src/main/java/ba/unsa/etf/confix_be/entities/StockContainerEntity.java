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
@Table(name = "stock_containers")
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class StockContainerEntity extends AutoIdBaseEntity {
    @Column(name = "container_id")
    private Long containerId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "container_id", insertable = false, updatable = false)
    private ContainerEntity container;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "depot_location")
    private LocalDate depotLocation;

    @Column(name = "current_status")
    private LocalDate currentStatus;

    @Column(name = "remarks")
    private LocalDate remarks;
}
