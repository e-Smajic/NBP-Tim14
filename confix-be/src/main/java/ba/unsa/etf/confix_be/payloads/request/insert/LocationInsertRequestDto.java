package ba.unsa.etf.confix_be.payloads.request.insert;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class LocationInsertRequestDto {
    @NotBlank
    private String name;

    @Length(min = 3)
    private String description;
}
