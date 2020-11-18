package org.example.app.serviceLoader;

import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * PersonLoader
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/18 下午11:02
 */
@Configuration
public class PersonLoader extends ServiceLoaderFactoryBean {

    @PostConstruct
    public void setServiceType() {
        super.setServiceType(StudentFactory.class);
    }
}
