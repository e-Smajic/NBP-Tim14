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
public class StockContainerResponseDto {
    private Long id;
    private Long containerId;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String depotLocation;
    private String currentStatus;
    private String remarks;
}
