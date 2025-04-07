package ba.unsa.etf.confix_be.core.exceptions;

import ba.unsa.etf.confix_be.core.localization.MessageUtil;
import org.springframework.http.HttpStatus;

/**
 * Exception representing a bad request error in the depot management system.
 *
 * <p>
 * This exception is thrown when the system identifies an invalid or inappropriate
 * request, such as when the client sends a request with incorrect data format or missing
 * required fields. It typically results in an HTTP 400 Bad Request response.
 * </p>
 */
public class BadRequestException extends BaseReportException {

    /**
     * Default HTTP status code for bad request errors.
     */
    private static final HttpStatus DEFAULT_STATUS = HttpStatus.BAD_REQUEST;

    /**
     * Constructs a new BadRequestException with a default error code and message.
     */
    public BadRequestException() {
        super(DEFAULT_STATUS, ReportErrorCode.BAD_REQUEST, MessageUtil.getMessage("error.bad_request"));
    }

    /**
     * Constructs a new BadRequestException with a default error code and a specified message.
     *
     * @param message the detailed message of the exception
     */
    public BadRequestException(String message) {
        super(DEFAULT_STATUS, ReportErrorCode.BAD_REQUEST, message);
    }

    /**
     * Constructs a new BadRequestException with a specified error code and message.
     *
     * @param error   the error code associated with the exception
     * @param message the detailed message of the exception
     */
    public BadRequestException(ReportErrorCode error, String message) {
        super(DEFAULT_STATUS, error, message);
    }

    /**
     * Constructs a new BadRequestException with a specified error code and throwable.
     * The message from the throwable is used as the exception message.
     *
     * @param error     the error code associated with the exception
     * @param throwable the throwable that caused this exception
     */
    public BadRequestException(ReportErrorCode error, Throwable throwable) {
        super(DEFAULT_STATUS, error, throwable.getMessage());
        initCause(throwable);
    }

    /**
     * Constructs a new BadRequestException with a specified error code, message,
     * and throwable.
     *
     * @param error     the error code associated with the exception
     * @param message   the detailed message of the exception
     * @param throwable the throwable that caused this exception
     */
    public BadRequestException(ReportErrorCode error, String message, Throwable throwable) {
        super(DEFAULT_STATUS, error, message);
        initCause(throwable);
    }

    /**
     * Constructs a new BadRequestException with a specified error code, message,
     * and additional data.
     *
     * @param error   the error code associated with the exception
     * @param message the detailed message of the exception
     * @param data    additional data that might be useful for exception handling or logging
     */
    public BadRequestException(ReportErrorCode error, String message, Object data) {
        super(DEFAULT_STATUS, error, message);
        setData(data);
    }
}
