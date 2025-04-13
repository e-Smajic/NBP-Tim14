package ba.unsa.etf.confix_be.entities;

import ba.unsa.etf.confix_be.core.entities.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "nbp_log", schema = "nbp")
public class LogEntity extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action_name", columnDefinition = "VARCHAR2(255)")
    private String actionName;

    @Column(name = "table_name", columnDefinition = "VARCHAR2(255)")
    private String tableName;

    @Column(name = "date_time", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private LocalDateTime dateTime;

    @Column(name = "db_user", columnDefinition = "VARCHAR2(255)")
    private String dbUser;
}
