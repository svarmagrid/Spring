package org.example.DynamicBeanRegistration.config;

import org.example.DynamicBeanRegistration.beans.Bike;
import org.example.DynamicBeanRegistration.beans.Engine;
import org.example.DynamicBeanRegistration.beans.Vehicle;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

import java.util.Random;

public class MyBeanRegistrar implements BeanRegistrar {


    @Override
    public void register(BeanRegistry registry, Environment env) {
        int num = new Random().nextInt(100);
        System.out.println("Generate number: "+num);
        if(num % 2 ==0){
            System.out.println("EVEN -> Registering Engine + vehicle");
            registry.registerBean("engine",Engine.class, spec -> spec.supplier(
                    context ->{
                        Engine engine = new Engine();
                        engine.setName("V8 Turbo");
                        return engine;
                    }
            ));
            registry.registerBean("vehicle", Vehicle.class, spec -> spec.supplier(
                    context ->{
                        Vehicle veh = new Vehicle(context.bean(Engine.class));
                        veh.setName("Sports Car");
                        return veh;
                    }
            ));
        }else {
            System.out.println("ODD -> Registering Bike");
            registry.registerBean("bike", Bike.class, spec -> spec.supplier(
                    context ->{
                        Bike bike = new Bike();
                        bike.setName("Super Bike");
                        return bike;
                    }
            ));
        }
    }
}
