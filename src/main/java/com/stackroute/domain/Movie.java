package com.stackroute.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Movie implements BeanFactoryAware, ApplicationContextAware, BeanNameAware {
private ApplicationContext context;
 @Autowired
  Actor actor;
    public Movie(){

    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie(Actor actor) {
        this.actor = actor;
    }


    public void displayActorDetails(){
        System.out.println(actor.name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
       System.out.println(beanFactory.toString());

    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("Bean name is "+beanName);

    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }
}
