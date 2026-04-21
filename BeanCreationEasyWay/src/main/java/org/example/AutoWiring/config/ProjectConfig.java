package org.example.AutoWiring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.AutoWiring.beans"})
public class ProjectConfig {

}
