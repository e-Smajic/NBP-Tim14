package ba.unsa.etf.confix_be.payloads.request.update;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepairMaterialUpdateRequestDto {
    private Long checklineId;
    private Long materialId;

    @PositiveOrZero
    private Integer quantityUsed;

    @PositiveOrZero
    private Double cost;
}
