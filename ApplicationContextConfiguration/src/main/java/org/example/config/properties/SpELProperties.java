package org.example.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my")
public class SpELProperties {

    private String values;

    public String getValues() {
        return values;
    }

    public String[] getValuesArray() {
        return values != null ? values.split("-") : new String[0];
    }

    public void setValues(String values) {
        this.values = values;
    }
}
