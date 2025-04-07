package ba.unsa.etf.confix_be.core.config;

import ba.unsa.etf.confix_be.core.exceptions.BaseReportException;
import ba.unsa.etf.confix_be.core.exceptions.ReportErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Objects;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Error result.
 */
record ErrorResult<D>(D data, ReportErrorCode error, String message) {

    public static <D> ErrorResult<D> of(D data, ReportErrorCode error, String message) {
        return new ErrorResult<>(data, error, message);
    }
}

/**
 * Global error handler.
 */
@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    /**
     * Handle base error.
     *
     * @param exception exception
     * @return error result
     */
    @ExceptionHandler(value = BaseReportException.class)
    protected ResponseEntity<ErrorResult<Object>> handleBaseError(BaseReportException exception) {
        var message = format("%s, by user %s", exception.getMessage(), Auth.getUserIdIfExists());
        log.error(message, exception);
        var error = ErrorResult.of(exception.getData(), exception.getError(), exception.getMessage());
        return new ResponseEntity<>(error, exception.getStatus());
    }

    /**
     * Handle validation error.
     *
     * @param exception exception
     * @return error result
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResult<List<String>>> handleValidationError(MethodArgumentNotValidException exception) {
        var message = format("%s, by user %s", exception.getMessage(), Auth.getUserIdIfExists());
        log.error(message, exception);
        var errors = exception.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .filter(Objects::nonNull)
                .toList();
        var error = ErrorResult.of(errors, ReportErrorCode.VALIDATION_FAILED, exception.getMessage());
        return new ResponseEntity<>(error, BAD_REQUEST);
    }

    /**
     * Handle other error.
     *
     * @param exception exception
     * @return error result
     */
    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<ErrorResult<Object>> handleOther(Exception exception) {
        var message = format("%s, by user %s", exception.getMessage(), Auth.getUserIdIfExists());
        log.error(message, exception);
        var error = ErrorResult.of(null, ReportErrorCode.UNKNOWN_ERROR, exception.getMessage());
        return new ResponseEntity<>(error, INTERNAL_SERVER_ERROR);
    }
}
