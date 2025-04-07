package ba.unsa.etf.confix_be.core.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * Utility class for date operations.
 *
 * <p>
 * This class provides various utility methods related to date operations which can be used
 * throughout the application wherever date-specific logic is required.
 * </p>
 *
 * <p>
 * As of the current implementation, it provides a method to check if a date is within a given range.
 * More methods can be added in the future to cater to more date-related operations.
 * </p>
 */
public class DateUtils {

    /**
     * Checks if a date is inside a given range, including the start and end dates.
     *
     * <p>
     * This method checks if the provided date is within the range specified by the
     * 'from' and 'to' dates, inclusive of these boundary dates.
     * </p>
     *
     * @param date The date to check.
     * @param from The start of the date range.
     * @param to   The end of the date range.
     * @return {@code true} if the date is inside the range (or equal to the start or end), {@code false} otherwise.
     */
    public static boolean isDateInsideRange(LocalDate date, LocalDate from, LocalDate to) {
        if (date.equals(from) || date.equals(to)) {
            return true;
        } else {
            return date.isAfter(from) && date.isBefore(to);
        }
    }

    public static LocalDate parseDate(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, formatter);
    }

    public static Instant parseInstant(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, formatter).atStartOfDay().toInstant(ZoneOffset.UTC);
    }

    public static LocalDateTime parseDateTime(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(date, formatter);
    }

    public static ZonedDateTime toZonedDateTime(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Instant) {
            return ((Instant) temporalAccessor).atZone(ZoneId.systemDefault());
        } else if (temporalAccessor instanceof LocalDate) {
            return ((LocalDate) temporalAccessor).atStartOfDay(ZoneId.systemDefault());
        } else if (temporalAccessor instanceof LocalDateTime) {
            return ((LocalDateTime) temporalAccessor).atZone(ZoneId.systemDefault());
        } else {
            return null;
        }
    }
}
