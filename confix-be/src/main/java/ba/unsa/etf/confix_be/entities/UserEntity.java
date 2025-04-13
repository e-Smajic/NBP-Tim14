package ba.unsa.etf.confix_be.entities;

import ba.unsa.etf.confix_be.core.entities.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "nbp_user", schema = "nbp")
public class UserEntity extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", columnDefinition = "VARCHAR2(255)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR2(255)")
    private String lastName;

    @Column(name = "username", columnDefinition = "VARCHAR2(255)")
    private String username;

    @Column(name = "email", columnDefinition = "VARCHAR2(255)")
    private String email;

    @Column(name = "password", columnDefinition = "VARCHAR2(255)")
    private String password;

    @Column(name = "phone_number", columnDefinition = "VARCHAR2(20)")
    private String phoneNumber;

    @Column(name = "birth_date", columnDefinition = "DATE")
    private LocalDate birthDate;

    @Column(name = "address_id", columnDefinition = "NUMBER")
    private Long addressId;
}
