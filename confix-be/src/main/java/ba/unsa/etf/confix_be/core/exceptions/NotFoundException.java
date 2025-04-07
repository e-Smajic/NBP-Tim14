package ba.unsa.etf.confix_be.core.exceptions;

import ba.unsa.etf.confix_be.core.localization.MessageUtil;
import org.springframework.http.HttpStatus;

/**
 * Represents an exception indicating that a requested resource could not be found.
 *
 * <p>
 * This exception is typically thrown when there's an attempt to retrieve or operate on
 * a resource that does not exist in the system. The associated HTTP status code for
 * this exception is 404 NOT FOUND.
 * </p>
 */
public class NotFoundException extends BaseReportException {

    /**
     * Default HTTP status code for this exception.
     */
    private static final HttpStatus DEFAULT_STATUS = HttpStatus.NOT_FOUND;

    /**
     * Default constructor using a generic "Resource not found" message.
     */
    public NotFoundException() {
        super(DEFAULT_STATUS, ReportErrorCode.RESOURCE_NOT_FOUND, MessageUtil.getMessage("error.resource_not_found"));
    }

    /**
     * Constructor to provide a custom error message.
     *
     * @param message A detailed error message.
     */
    public NotFoundException(String message) {
        super(DEFAULT_STATUS, ReportErrorCode.RESOURCE_NOT_FOUND, message);
    }

    /**
     * Constructor to provide a custom error code and message.
     *
     * @param error   A specific error code.
     * @param message A detailed error message.
     */
    public NotFoundException(ReportErrorCode error, String message) {
        super(DEFAULT_STATUS, error, message);
    }

    /**
     * Constructor to provide a custom error code, message, and additional data.
     *
     * @param error   A specific error code.
     * @param message A detailed error message.
     * @param data    Additional data providing context about the error.
     */
    public NotFoundException(ReportErrorCode error, String message, Object data) {
        super(DEFAULT_STATUS, error, message);
        setData(data);
    }
}
