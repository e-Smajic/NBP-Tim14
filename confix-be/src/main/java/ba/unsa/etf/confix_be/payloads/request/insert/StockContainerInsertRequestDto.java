package ba.unsa.etf.confix_be.payloads.request.insert;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class StockContainerInsertRequestDto {
    private Long containerId;

    private LocalDate arrivalDate;

    private LocalDate departureDate;

    @Length(min = 3)
    private String depotLocation;

    @Length(min = 3)
    private String currentStatus;

    private String remarks;
}
