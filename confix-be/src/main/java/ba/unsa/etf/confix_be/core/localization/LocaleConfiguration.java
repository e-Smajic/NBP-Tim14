package ba.unsa.etf.confix_be.core.localization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Configuration
public class LocaleConfiguration {

    private static final String DEFAULT_LOCALE = "en";

    @Bean
    public LocaleResolver localeResolver() {
        var localeResolver = new AcceptHeaderResolver();
        localeResolver.setDefaultLocale(Locale.forLanguageTag(DEFAULT_LOCALE));
        return localeResolver;
    }

}