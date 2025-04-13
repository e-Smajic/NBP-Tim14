package ba.unsa.etf.confix_be.payloads.request.insert;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class UserInsertRequestDto {
    @Length(min = 3)
    private String firstName;

    @Length(min = 3)
    private String lastName;

    private String username;

    @Length(min = 3)
    private String email;

    @Length(min = 8)
    private String password;

    @Length(min = 3)
    private String phoneNumber;

    private LocalDate birthDate;

    private String addressId;

    private String roleId;
}
