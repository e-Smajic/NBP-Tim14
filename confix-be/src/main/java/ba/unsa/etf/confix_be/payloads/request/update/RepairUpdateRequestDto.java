package ba.unsa.etf.confix_be.payloads.request.update;

import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class RepairUpdateRequestDto {
    @Length(min = 3)
    private String code;

    @Length(min = 3)
    private String description;

    @DecimalMin(value = "0.0", inclusive = true)
    private Double laborHours;
}
