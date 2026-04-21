package org.example;

import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Application is running...");
        context.close();
        context1.close();
    }
}
