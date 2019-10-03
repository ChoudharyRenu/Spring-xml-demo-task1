package com.stackroute.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycleDemoBean implements DisposableBean, InitializingBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy the bean");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After properties are set");
    }
    public  void customDestroy(){
        System.out.println("custom destroy method called");
    }
    public void customInit(){
        System.out.println("custom init called");
    }
}
