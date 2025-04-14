package ba.unsa.etf.confix_be.payloads.response;

import ba.unsa.etf.confix_be.enums.ReportState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponseDto {
    private Long id;
    private Long inspectionId;
    private LocalDate reportDate;
    private String repairedBy;
    private LocalDate repairCompletionDate;
    private ReportState state;
    private String comments;
    private Long createdBy;
    private Long repairedById;
}
