package ba.unsa.etf.confix_be.payloads.request.insert;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class DamageInsertRequestDto {

    @Length(min = 3)
    private String code;

    private String name;
}
