package org.example.config.common;

import java.time.Clock;
import java.time.format.DateTimeFormatter;
import org.example.config.properties.AppProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FormattingConfig {

    @Bean
    public Clock applicationClock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    public DateTimeFormatter applicationDateFormatter(AppProperties appProperties) {
        return DateTimeFormatter.ofPattern(appProperties.getFormatting().getDatePattern());
    }

    @Bean
    public DateTimeFormatter applicationTimeFormatter(AppProperties appProperties) {
        return DateTimeFormatter.ofPattern(appProperties.getFormatting().getTimePattern());
    }
}
