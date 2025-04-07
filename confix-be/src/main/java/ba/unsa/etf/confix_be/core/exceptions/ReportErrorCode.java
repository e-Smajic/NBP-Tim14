package ba.unsa.etf.confix_be.core.exceptions;

/**
 * Enumeration representing various error codes in the depot management system.
 *
 * <p>
 * This enum provides distinct values to identify various types of errors that
 * can occur within the depot management system. Each error code is indicative of
 * a specific kind of failure or exceptional scenario.
 * </p>
 *
 */
public enum ReportErrorCode {

    /** Indicates that a requested resource could not be found. */
    RESOURCE_NOT_FOUND,

    /** Indicates an issue with the provided query parameter(s). */
    WRONG_QUERY_PARAMETER,

    /** Indicates that some validation failed, such as invalid data format. */
    VALIDATION_FAILED,

    /** Indicates a conflict, such as when trying to create a resource that already exists. */
    CONFLICT,

    /** Indicates that the request was invalid or improperly formatted. */
    BAD_REQUEST,

    /** Indicates an authentication failure. */
    UNAUTHENTICATED,

    /** Indicates an authorization failure (insufficient permissions). */
    UNAUTHORIZED,

    /** Indicates an unknown or unspecified error. */
    UNKNOWN_ERROR,
}
