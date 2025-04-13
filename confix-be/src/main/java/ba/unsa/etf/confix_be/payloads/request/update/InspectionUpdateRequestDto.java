package ba.unsa.etf.confix_be.payloads.request.update;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class InspectionUpdateRequestDto {
    private Long stockContainerId;

    private LocalDate inspectionDate;

    @Length(min = 3)
    private LocalDate inspectorName;

    @NotBlank
    private LocalDate notes;

    @NotBlank
    private LocalDate condition;
}
