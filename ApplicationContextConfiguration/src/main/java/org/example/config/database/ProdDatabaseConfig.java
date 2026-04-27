package org.example.config.database;

import javax.sql.DataSource;
import org.example.config.properties.DatabaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
@EnableConfigurationProperties(DatabaseProperties.class)
public class ProdDatabaseConfig {

    @Bean
    public DataSource dataSource(DatabaseProperties databaseProperties) {
        return DataSourceBuilder.create()
                .url(databaseProperties.getUrl())
                .username(databaseProperties.getUsername())
                .password(databaseProperties.getPassword())
                .driverClassName(databaseProperties.getDriverClassName())
                .build();
    }

    @Bean
    public String databaseDescription() {
        return "Prod profile uses PostgreSQL credentials from environment variables";
    }
}
