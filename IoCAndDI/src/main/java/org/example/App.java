package org.example;

import org.example.config.AppConfig;
import org.example.service.BusinessService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BusinessService service = context.getBean(BusinessService.class);
        service.run();
        context.close();
    }
}
