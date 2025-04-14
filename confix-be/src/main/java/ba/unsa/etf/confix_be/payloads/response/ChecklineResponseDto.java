package ba.unsa.etf.confix_be.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChecklineResponseDto {
    private Long id;
    private Long reportId;
    private Long locationId;
    private Long componentId;
    private Long damageId;
    private Long repairId;
    private Long materialId;
    private Double length;
    private Double width;
    private Integer quantity;
    private String remarks;
    private Double cost;
    private Boolean isRepaired;
}
