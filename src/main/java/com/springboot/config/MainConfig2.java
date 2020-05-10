package com.springboot.config;

import com.springboot.bean.BeanTests;
import com.springboot.bean.Color;
import com.springboot.bean.ColorFactory;
import com.springboot.bean.Person;
import com.springboot.condition.LinuxCondition;
import com.springboot.condition.MyImportBeanDefinitionRegistrar;
import com.springboot.condition.MyImportSelector;
import com.springboot.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @author yc
 * @create 2020-04-26-21:09
 */
@Import(value = {Color.class,BeanTests.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@Configuration
public class MainConfig2 {

    @Scope
    @Lazy
    @Bean("person02")
    public Person person()
    {
        System.out.println("person被加载了");
        return new Person("yc",24,false);
    }

    @Conditional(value = WindowsCondition.class)
    @Bean("person-bill")
    public Person person2()
    {
        Person p = new Person("Bill Gates",65,true);
        return p;
    }
    @Conditional(value = LinuxCondition.class)
    @Bean("person-linus")
    public Person person3()
    {
        Person p = new Person("Linus",51,true);
        return p;
    }

    @Bean
    public ColorFactory colorFactory()
    {
        return new ColorFactory();
    }

}
