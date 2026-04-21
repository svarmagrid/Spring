package org.example.ex1;

import org.example.ex1.beans.Vehicle;
import org.example.ex1.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main(String[] args)
    {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle name: "+veh.getName());
        veh.sayHello();
        context.close();
    }
}
