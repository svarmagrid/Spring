package org.example.config;

import org.example.service.DefaultService;
import org.example.service.MyService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnProperty(prefix = "my.service", name = "enabled", havingValue = "true", matchIfMissing = true)
public class MyAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(MyService.class)
    public MyService myService(){
        return new DefaultService();
    }
}
