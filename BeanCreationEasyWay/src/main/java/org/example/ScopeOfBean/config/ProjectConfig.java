package org.example.ScopeOfBean.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"org.example.ScopeOfBean.beans"})
public class ProjectConfig {
}
