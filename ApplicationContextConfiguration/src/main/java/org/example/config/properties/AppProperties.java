package org.example.config.properties;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private String name;
    private List<String> supportedFormats = new ArrayList<>();
    private Formatting formatting = new Formatting();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSupportedFormats() {
        return supportedFormats;
    }

    public void setSupportedFormats(List<String> supportedFormats) {
        this.supportedFormats = supportedFormats;
    }

    public Formatting getFormatting() {
        return formatting;
    }

    public void setFormatting(Formatting formatting) {
        this.formatting = formatting;
    }

    public static class Formatting {

        private String datePattern;
        private String timePattern;

        public String getDatePattern() {
            return datePattern;
        }

        public void setDatePattern(String datePattern) {
            this.datePattern = datePattern;
        }

        public String getTimePattern() {
            return timePattern;
        }

        public void setTimePattern(String timePattern) {
            this.timePattern = timePattern;
        }
    }
}
