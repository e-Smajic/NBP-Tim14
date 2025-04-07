package ba.unsa.etf.confix_be.core.model;

import ba.unsa.etf.confix_be.core.shared.ListDeletedEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents additional data parameters that can be included with search objects.
 *
 * <p>
 * This class is used to define any additional data parameters that might be necessary
 * when performing search operations. As of the current implementation, it allows specifying
 * an include path, which can be interpreted as a directive to include specific related entities
 * or details along with the primary search results.
 * </p>
 *
 * <p>
 * The actual interpretation and usage of the `includePath` parameter will be dependent on
 * the context in which the search is being performed and how the underlying service or
 * data access layer is implemented.
 * </p>
 *
 * <ul>
 *     <li>includePath - A string indicating additional data or related entities to include with the primary search results.</li>
 * </ul>
 */
@Getter
@Setter
public class SearchObjectAdditionalData {
    /**
     * A string indicating additional data or related entities to include with the primary search results.
     */
    private String includePath;
    private ListDeletedEnum deleted = ListDeletedEnum.ALL;
}
