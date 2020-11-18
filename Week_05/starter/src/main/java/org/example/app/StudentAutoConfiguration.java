package org.example.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * StudentAutoConfiguration
 *
 * @author duansg
 * @version 1.0
 * @date 2020/11/18 下午11:39
 */
@Configuration
@ConditionalOnClass(StudentService.class)
@EnableConfigurationProperties(StudentProperties.class)
public class StudentAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public StudentService createStudent(StudentProperties properties) {
        StudentService service = new StudentService();
        service.setId(properties.getId());
        service.setName(properties.getName());
        return service;
    }
}