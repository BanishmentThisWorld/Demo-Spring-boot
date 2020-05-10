package com.springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author yc
 * @create 2020-04-30-14:54
 */

/**
 * 后置处理器，初始化前后进行处理工作
 */
@Component
public class MyBeanPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
      //  System.out.println("postProcessBeforeInitialization->"+beanName+"->"+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      //  System.out.println("postProcessAfterInitialization->"+beanName+"->"+bean);
        return bean;
    }
}
