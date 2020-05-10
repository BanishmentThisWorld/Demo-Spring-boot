package com.springboot.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author yc
 * @create 2020-04-29-13:41
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
       // System.out.println("cat ...destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       // System.out.println("cat ... afterPropertiesSet...");
    }

    public Cat()
    {
       // System.out.println("cat constructor...");
    }
}
