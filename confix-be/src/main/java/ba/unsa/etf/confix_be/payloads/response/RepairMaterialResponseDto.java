package ba.unsa.etf.confix_be.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RepairMaterialResponseDto {
    private Long id;
    private Long checklineId;
    private Long materialId;
    private Integer quantityUsed;
    private Double cost;
}
