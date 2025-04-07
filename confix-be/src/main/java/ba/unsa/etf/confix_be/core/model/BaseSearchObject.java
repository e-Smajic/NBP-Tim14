package ba.unsa.etf.confix_be.core.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a base search criteria object used for pagination and sorting of results.
 *
 * <p>
 * This class serves as a foundational object for search-related operations. It provides
 * common pagination fields like 'page', 'limit', as well as ordering and filtering capabilities.
 * It can be extended by other search objects to add more specific search criteria.
 * </p>
 *
 * <p>
 * The class extends {@code SearchObjectAdditionalData}, which can be used to provide any
 * additional search metadata or context.
 * </p>
 *
 * <ul>
 *     <li>page - Represents the current page number in pagination.</li>
 *     <li>limit - Represents the number of items per page.</li>
 *     <li>order - Represents the ordering criteria for results (e.g., ascending or descending).</li>
 *     <li>id - A generic identifier used for specific record searches.</li>
 *     <li>includeCount - Indicates whether the total count of records should be included in the response.</li>
 *     <li>getAll - Indicates whether all records, bypassing pagination, should be fetched.</li>
 * </ul>
 *
 * @param <T> the type of the identifier (e.g., Long, String, UUID)
 */
@Getter
@Setter
public class BaseSearchObject<T> extends SearchObjectAdditionalData {
    private Integer page = 0;
    private Integer limit = 10;
    /**
     * Represents the ordering criteria for results (e.g., ascending or descending).
     */
    private String order;
    private T id;
    /**
     * Indicates whether the total count of records should be included in the response.
     */
    private Boolean includeCount;
    /**
     * Indicates whether all records, bypassing pagination, should be fetched.
     */
    private Boolean getAll;
}
