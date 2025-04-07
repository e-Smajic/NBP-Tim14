package ba.unsa.etf.confix_be.core.localization;

import ba.unsa.etf.confix_be.core.localization.constants.LocalizationConstants;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

public class AcceptHeaderResolver extends AcceptHeaderLocaleResolver {

    private static final String DEFAULT_LOCALE = "en";

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLangCode = request.getHeader(LocalizationConstants.X_LANGUAGE_CODE);
        return headerLangCode == null || headerLangCode.isEmpty()
                ? new Locale(DEFAULT_LOCALE)
                : new Locale(headerLangCode);
    }


}