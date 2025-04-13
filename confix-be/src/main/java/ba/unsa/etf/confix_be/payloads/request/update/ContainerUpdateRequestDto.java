package ba.unsa.etf.confix_be.payloads.request.update;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class ContainerUpdateRequestDto {
    @NotBlank
    private String containerNumber;

    @Length(min = 3)
    private String containerType;

    @NotBlank
    private String containerSize;

    @NotBlank
    private String owner;

    private Long ownerId;
}
