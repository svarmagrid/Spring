package org.example.DynamicBeanRegistration;

import org.example.DynamicBeanRegistration.beans.Bike;
import org.example.DynamicBeanRegistration.beans.Engine;
import org.example.DynamicBeanRegistration.beans.Vehicle;
import org.example.DynamicBeanRegistration.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        if (context.containsBean("engine")){
            var engine = context.getBean(Engine.class);
            System.out.println("Engine name: "+engine.getName());
        }
        if(context.containsBean("vehicle")){
            var vehicle = context.getBean(Vehicle.class);
            System.out.println("Vehicle name: "+vehicle.getName());
            System.out.println("Vehicle Engine: "+vehicle.getEngine());
        }

        if (context.containsBean("bike")){
            var bike = context.getBean(Bike.class);
            System.out.println("Bike name: "+bike.getName());
        }
    }
}
