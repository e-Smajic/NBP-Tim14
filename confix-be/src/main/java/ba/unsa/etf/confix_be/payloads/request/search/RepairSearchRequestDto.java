package ba.unsa.etf.confix_be.payloads.request.search;

import ba.unsa.etf.confix_be.core.model.BaseSearchObject;
import ba.unsa.etf.confix_be.entities.RepairEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepairSearchRequestDto extends BaseSearchObject<Long> {
}
