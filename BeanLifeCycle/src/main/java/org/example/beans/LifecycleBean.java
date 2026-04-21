package org.example.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("lifecycleBean")
public class LifecycleBean implements InitializingBean, DisposableBean, BeanNameAware, ApplicationContextAware {

    public LifecycleBean() {
        System.out.println("Instantiation (Constructor) ");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware: "+name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("@afterPropertiesSet()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("@PostConstruct");
    }

    public void customInit() {
        System.out.println("Custom initMethod");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy");
    }

    public void customDestroy() {
        System.out.println("Custom destroyMethod");
    }
}
