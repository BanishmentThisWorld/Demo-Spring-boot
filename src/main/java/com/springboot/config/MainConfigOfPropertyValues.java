package com.springboot.config;

import com.springboot.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author yc
 * @create 2020-05-05-22:57
 */
@PropertySource(value = {"classpath:person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

    @Bean("personValues")
    public Person person(){
        return new Person();
    }
}
