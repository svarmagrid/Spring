package org.example.config.startup;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import javax.sql.DataSource;
import org.example.config.properties.AppProperties;
import org.example.config.properties.SpELProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class StartupReportConfig {

    @Bean
    public CommandLineRunner startupReport(
            Environment environment,
            AppProperties appProperties,
            SpELProperties spELProperties,
            ObjectProvider<DataSource> dataSourceProvider) {
        return args -> {
            System.out.println("Application: " + appProperties.getName());
            System.out.println("Active profiles: " + Arrays.toString(environment.getActiveProfiles()));
            System.out.println("Supported date formats: " + appProperties.getSupportedFormats());
            System.out.println("Custom values: " + Arrays.toString(spELProperties.getValuesArray()));
            printDatabaseInfo(dataSourceProvider.getIfAvailable());
        };
    }

    private void printDatabaseInfo(DataSource dataSource) {
        if (dataSource == null) {
            System.out.println("Database: No datasource configured");
            return;
        }

        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Database: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("Database URL: " + connection.getMetaData().getURL());
        } catch (SQLException exception) {
            System.out.println("Database: Unable to determine database type");
            System.out.println("Database error: " + exception.getMessage());
        }
    }

}
