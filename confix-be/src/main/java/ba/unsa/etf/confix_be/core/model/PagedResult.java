package ba.unsa.etf.confix_be.core.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Represents a paginated set of results with information about the total count and whether there are more results.
 *
 * <p>
 * This class is used to encapsulate a paginated result set, providing details about the total number of results
 * (`count`), the actual list of results (`resultList`), and whether there are more results available beyond the
 * current page (`hasMore`).
 * </p>
 *
 * <p>
 * By using this object, client applications can easily understand the context of the results, whether they should
 * fetch the next page, and the overall number of records that match their search or listing criteria.
 * </p>
 *
 * <ul>
 *     <li>hasMore - Indicates if there are more records available beyond the current result set.</li>
 *     <li>resultList - The actual list of results for the current page.</li>
 *     <li>count - Total count of records that match the criteria, not just the current page.</li>
 * </ul>
 *
 * @param <T> the type of the results, could be any entity or DTO
 */
@Getter
@Setter
public class PagedResult<T> {
    /**
     * Indicates if there are more records available beyond the current result set.
     */
    public Boolean hasMore;
    public List<T> resultList;
    public Long count;
}
