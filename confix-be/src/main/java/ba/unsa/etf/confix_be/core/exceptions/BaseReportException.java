package ba.unsa.etf.confix_be.core.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Represents a base exception class for all report-related exceptions.
 *
 * <p>
 * This exception encapsulates the error details such as the HTTP status, error code,
 * a user-friendly error message, and any additional data that provides more context about the error.
 * Subclasses can use this to provide more specific exception details and handling.
 * </p>
 */
@Getter
@Setter
public class BaseReportException extends RuntimeException {

    /**
     * The HTTP status code that should be returned to the client.
     */
    private final HttpStatus status;
    /**
     * A specific code identifying the type or nature of the error.
     */
    private final ReportErrorCode error;
    /**
     * A detailed message providing information about the error. This message
     * can be displayed to end-users or used for debugging purposes.
     */
    private final String message;
    /**
     * Additional data that provides more context about the error. This
     * can be used for logging, debugging, or to provide more detailed information to clients.
     */
    private Object data;

    public BaseReportException(HttpStatus status, ReportErrorCode error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
