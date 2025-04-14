package ba.unsa.etf.confix_be.payloads.request.insert;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class InspectionInsertRequestDto {
    private Long stockContainerId;

    private LocalDate inspectionDate;

    @Length(min = 3)
    private LocalDate inspectorName;

    @NotBlank
    private LocalDate notes;

    @NotBlank
    private LocalDate condition;
}
