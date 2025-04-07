package ba.unsa.etf.confix_be.core.exceptions;

import ba.unsa.etf.confix_be.core.localization.MessageUtil;
import org.springframework.http.HttpStatus;

/**
 * Exception thrown to indicate that a user does not have the required
 * authorization to access a particular resource or perform an operation.
 *
 * <p>
 * This exception is typically used in context of security checks in web
 * applications, especially when a user tries to access a resource
 * or execute an action for which they don't have the necessary permissions.
 * </p>
 */
public class AuthorizationException extends BaseReportException {

    /**
     * The default HTTP status to be associated with this exception.
     */
    private static final HttpStatus DEFAULT_STATUS = HttpStatus.FORBIDDEN;

    /**
     * Default constructor that initializes the exception with
     * the default HTTP status and a standard error message.
     */
    public AuthorizationException() {
        super(DEFAULT_STATUS, ReportErrorCode.UNAUTHORIZED, MessageUtil.getMessage("error.unauthorized"));
    }

    /**
     * Constructs the exception with a specified error code and message.
     *
     * @param error   the error code representing the type of error
     * @param message the detailed message associated with the error
     */
    public AuthorizationException(ReportErrorCode error, String message) {
        super(DEFAULT_STATUS, error, message);
    }

    /**
     * Constructs the exception with a specified error code, message, and additional data.
     *
     * @param error   the error code representing the type of error
     * @param message the detailed message associated with the error
     * @param data    additional data related to the error, which can be useful for further
     *                debugging or providing more context to the client
     */
    public AuthorizationException(ReportErrorCode error, String message, Object data) {
        super(DEFAULT_STATUS, error, message);
        setData(data);
    }
}
