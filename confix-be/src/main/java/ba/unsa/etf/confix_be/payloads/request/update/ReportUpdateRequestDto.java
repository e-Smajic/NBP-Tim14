package ba.unsa.etf.confix_be.payloads.request.update;

import ba.unsa.etf.confix_be.enums.ReportState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReportUpdateRequestDto {
    @NotNull
    private Long inspectionId;

    private LocalDate reportDate;

    @NotBlank
    private String repairedBy;

    private LocalDate repairCompletionDate;

    @NotNull
    private ReportState state;

    @NotBlank
    private String comments;

    @NotNull
    private Long createdBy;

    @NotNull
    private Long repairedById;
}
