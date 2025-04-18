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
@Table(name = "containers")
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ContainerEntity extends AutoIdBaseEntity {
    @Column(name = "container_number")
    private String containerNumber;

    @Column(name = "container_type")
    private String containerType;

    @Column(name = "container_size")
    private String containerSize;

    @Column(name = "owner")
    private String owner;

    @Column(name = "owner_id")
    private Long ownerId;
}
