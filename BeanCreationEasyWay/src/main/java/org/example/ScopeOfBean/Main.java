package org.example.ScopeOfBean;

import org.example.ScopeOfBean.beans.MyService;
import org.example.ScopeOfBean.beans.UserSession;
import org.example.ScopeOfBean.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service1 = context.getBean(MyService.class);
        var service2 = context.getBean(MyService.class);
        System.out.println(service2.hashCode());
        System.out.println(service1.hashCode());

        var userService1 = context.getBean(UserSession.class);
        System.out.println(userService1.hashCode());
        System.out.println(userService1.getSessionId());

        var userService2 = context.getBean(UserSession.class);
        System.out.println(userService2.hashCode());
        System.out.println(userService2.getSessionId());
    }
}
