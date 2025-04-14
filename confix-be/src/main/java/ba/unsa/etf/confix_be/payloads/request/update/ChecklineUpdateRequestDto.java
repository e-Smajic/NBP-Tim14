package ba.unsa.etf.confix_be.payloads.request.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChecklineUpdateRequestDto {
    @NotNull
    private Long reportId;

    @NotNull
    private Long locationId;

    @NotNull
    private Long componentId;

    @NotNull
    private Long damageId;

    @NotNull
    private Long repairId;

    @NotNull
    private Long materialId;

    @PositiveOrZero
    private Double length;

    @PositiveOrZero
    private Double width;

    @PositiveOrZero
    private Integer quantity;

    @NotBlank
    private String remarks;

    @PositiveOrZero
    private Double cost;

    @NotNull
    private Boolean isRepaired;
}
