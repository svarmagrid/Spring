package org.example.config.startup;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.PropertySource;

@Configuration
public class DiagnosticsStartupConfig {

    @Bean
    public CommandLineRunner diagnosticsStartupRunner(
            ConfigurableEnvironment environment,
            ApplicationContext applicationContext) {
        return args -> {
            printEnvironmentProperties(environment);
            printBeanNames(applicationContext);
        };
    }

    private void printEnvironmentProperties(ConfigurableEnvironment environment) {
        Map<String, Object> properties = new TreeMap<>();

        for (PropertySource<?> propertySource : environment.getPropertySources()) {
            if (propertySource instanceof EnumerablePropertySource<?>) {
                EnumerablePropertySource<?> enumerablePropertySource =
                        (EnumerablePropertySource<?>) propertySource;
                for (String propertyName : enumerablePropertySource.getPropertyNames()) {
                    properties.putIfAbsent(propertyName, environment.getProperty(propertyName));
                }
            }
        }

        System.out.println("\nEnvironment properties:");
        properties.forEach((name, value) -> System.out.println(name + "=" + value));
    }

    private void printBeanNames(ApplicationContext applicationContext) {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        System.out.println("\nApplication context beans:");
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
