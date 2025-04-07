package ba.unsa.etf.confix_be.core.exceptions;

import ba.unsa.etf.confix_be.core.localization.MessageUtil;
import org.springframework.http.HttpStatus;

/**
 * Exception representing an authentication failure in the depot management system.
 *
 * <p>
 * This exception is thrown when there are issues related to user authentication,
 * such as when a user tries to access a resource without being authenticated.
 * It typically results in an HTTP 401 Unauthorized response.
 * </p>
 */
public class AuthenticationException extends BaseReportException {

    /**
     * Default HTTP status code for authentication errors.
     */
    private static final HttpStatus DEFAULT_STATUS = HttpStatus.UNAUTHORIZED;

    /**
     * Constructs a new AuthenticationException with a default error code and message.
     */
    public AuthenticationException() {
        super(DEFAULT_STATUS, ReportErrorCode.UNAUTHENTICATED, MessageUtil.getMessage("error.unauthenticated"));
    }

    /**
     * Constructs a new AuthenticationException with a specified error code and message.
     *
     * @param error   the error code associated with the exception
     * @param message the detailed message of the exception
     */
    public AuthenticationException(ReportErrorCode error, String message) {
        super(DEFAULT_STATUS, error, message);
    }

    /**
     * Constructs a new AuthenticationException with a specified error code, message,
     * and additional data.
     *
     * @param error   the error code associated with the exception
     * @param message the detailed message of the exception
     * @param data    additional data that might be useful for exception handling or logging
     */
    public AuthenticationException(ReportErrorCode error, String message, Object data) {
        super(DEFAULT_STATUS, error, message);
        setData(data);
    }
}
