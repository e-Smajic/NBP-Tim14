package ba.unsa.etf.confix_be.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContainerResponseDto {
    private Long id;
    private String containerName;
    private String containerType;
    private String containerSize;
    private String owner;
    private Long ownerId;
}
