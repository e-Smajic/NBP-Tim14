package ba.unsa.etf.confix_be.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InspectionResponseDto {
    private Long id;
    private Long stockContainerId;
    private LocalDate inspectionDate;
    private String inspectorName;
    private String notes;
    private String condition;
}
