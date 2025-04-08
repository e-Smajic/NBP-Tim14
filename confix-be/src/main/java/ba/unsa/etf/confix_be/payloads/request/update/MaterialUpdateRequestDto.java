package ba.unsa.etf.confix_be.payloads.request.update;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class MaterialUpdateRequestDto {
    @NotBlank
    private String name;

    @NotBlank
    private String unit;

    @DecimalMin(value = "0.0", inclusive = true)
    private Double costPerUnit;

    @Length(min = 3)
    private String description;
}
