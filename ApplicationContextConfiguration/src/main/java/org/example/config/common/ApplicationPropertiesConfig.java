package org.example.config.common;

import org.example.config.properties.AppProperties;
import org.example.config.properties.SpELProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({AppProperties.class, SpELProperties.class})
public class ApplicationPropertiesConfig {
}
