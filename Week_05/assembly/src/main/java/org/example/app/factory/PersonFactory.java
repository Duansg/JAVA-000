package org.example.app.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

/**
 * Person
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/18 下午11:00
 */
@Configuration
public class PersonFactory implements FactoryBean<Student> {

    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
