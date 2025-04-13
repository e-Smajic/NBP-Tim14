package ba.unsa.etf.confix_be.payloads.request.update;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class RoleUpdateRequestDto {
    @Length(min = 3)
    private String name;
}
