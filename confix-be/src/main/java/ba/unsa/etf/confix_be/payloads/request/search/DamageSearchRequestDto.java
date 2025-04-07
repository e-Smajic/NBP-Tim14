package ba.unsa.etf.confix_be.payloads.request.search;

import ba.unsa.etf.confix_be.core.model.BaseSearchObject;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO used to search damage codes.
 */
@Getter
@Setter
public class DamageSearchRequestDto extends BaseSearchObject<Long> {

}
