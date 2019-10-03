package com.stackroute;

import com.stackroute.domain.Actor;
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
        Actor actor = applicationContext.getBean("actor",Actor.class);
        Movie movie = applicationContext.getBean("movieA",Movie.class);
        movie.displayActorDetails();
        System.out.println("-------------------Using BeanFactory------------------------");
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        //XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("/home/cgi/Task1/src/main/resources/beans.xml"));
        //Actor actor = (Actor)factory.getBean("SRK");
        Movie movie1 = (Movie)factory.getBean("movieB");
        movie.displayActorDetails();
        System.out.println("--------------Using beansDefinitionRegistry----------------");
        BeanDefinitionRegistry beanDefinitionRegistry = new DefaultListableBeanFactory();
        BeanDefinitionReader  beanDefinitionReader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
        beanDefinitionReader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        Movie movie2 = (Movie)((DefaultListableBeanFactory) beanDefinitionRegistry).getBean("movieA");
        movie2.displayActorDetails();

        // task2 starts here
        System.out.println("-------------Task2 starts here-----------------");
        Movie  movie3 = applicationContext.getBean("3idiots",Movie.class);
        movie3.displayActorDetails();
        System.out.println(movie1==movie2);
    }
}
