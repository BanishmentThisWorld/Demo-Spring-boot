package com.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yc
 * @create 2020-04-15-22:57
 */
@Component
public class BeanTests {

  @Value("${person.name}")
    private String name;


    @Override
    public String toString() {
        return "BeanTests{" +
                "name='" + name + '\'' +
                '}';
    }
}
