package org.example.DynamicBeanRegistration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MyBeanRegistrar.class})
public class ProjectConfig {

}
