package ba.unsa.etf.confix_be.payloads.response;

import ba.unsa.etf.confix_be.core.interfaces.NameCodeIdInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO used to display damage codes.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DamageResponseDto implements NameCodeIdInterface {
    private Long id;
    private String name;
    private String code;
}