package com.stackroute;

import com.stackroute.domain.Actor;
import com.stackroute.domain.BeanLifeCycleDemoBean;
import com.stackroute.domain.Movie;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.security.cert.X509Certificate;

public class Main
{
    public static void main( String[] args )
    {
        System.out.println("----------------Using ApplicationContext-------------------");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Actor actor = applicationContext.getBean("akshay",Actor.class);
        Movie movie = applicationContext.getBean("movie",Movie.class);
        BeanLifeCycleDemoBean beanLifeCycleDemoBean = applicationContext.getBean("beanLifeCycle",BeanLifeCycleDemoBean.class);
        movie.displayActorDetails();
        try {
            beanLifeCycleDemoBean.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            beanLifeCycleDemoBean.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        beanLifeCycleDemoBean.customDestroy();
        beanLifeCycleDemoBean.customInit();

    }
}
