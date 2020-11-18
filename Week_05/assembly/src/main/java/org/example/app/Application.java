package org.example.app;

import org.example.app.annotation.Person;
import org.example.app.factory.PersonFactory;
import org.example.app.serviceLoader.PersonLoader;
import org.example.app.serviceLoader.Student;
import org.example.app.serviceLoader.StudentFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * A
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/18 下午10:55
 */
public class Application {

    public static void main(String[] args) throws Exception {
        /**
         * annotation
         */
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(Person.class);
//        applicationContext.refresh();
//        Person person = applicationContext.getBean(Person.class);

        /**
         * beanDefinition
         */
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
//        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
//        beanDefinition.setBeanClass(org.example.app.beanDefinition.Person.class);
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(org.example.app.beanDefinition.Person.class);
//        applicationContext.registerBeanDefinition("person", beanDefinition);
//        applicationContext.refresh();
//        org.example.app.beanDefinition.Person bean = applicationContext.getBean(org.example.app.beanDefinition.Person.class);

        /**
         * factory
         */
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(PersonFactory.class);
//        applicationContext.refresh();
//        PersonFactory personFactory = applicationContext.getBean(PersonFactory.class);
//        Student student = personFactory.getObject();

        /**
         * serviceLoader
         */
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//
//        applicationContext.register(PersonLoader.class);
//        applicationContext.refresh();
//
//        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
//        ServiceLoader<StudentFactory> bean = autowireCapableBeanFactory.getBean(ServiceLoader.class);
//
//        Iterator<StudentFactory> iterator = bean.iterator();
//        while (iterator.hasNext()) {
//            StudentFactory studentFactory = iterator.next();
//            Student student = studentFactory.createStudent();
//        }
        /**
         * xml
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) applicationContext.getBean("student");


    }
}
