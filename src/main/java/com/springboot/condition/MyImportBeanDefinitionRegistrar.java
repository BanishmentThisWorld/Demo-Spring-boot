package com.springboot.condition;

import com.springboot.bean.Green;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author yc
 * @create 2020-04-27-20:26
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

    /**
     * AnnotationMetadata ：当前类的注解信息
     * BeanDefinitionRegistry ： BeanDefinition注册类：
     *     把所有需要添加到容器中的bean； 调用 BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.springboot.bean.Blue");
        boolean blue = registry.containsBeanDefinition("com.springboot.bean.Red");
        if (red && blue) {
            // 指定bean的定义信息
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Green.class);
            // 注册一个bean，指定bean名为green
            registry.registerBeanDefinition("green",rootBeanDefinition);
        }
    }

}



