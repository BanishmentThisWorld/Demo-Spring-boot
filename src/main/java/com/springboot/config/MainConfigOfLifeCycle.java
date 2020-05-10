package com.springboot.config;

/**
 * @author yc
 * @create 2020-04-29-10:58
 */

import com.springboot.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Bean创建--初始化--销毁的过程
 * 容器管理Bean的声明周期：
 * 我们可以自定义初始化和销毁方法：容器在bean进行到当前声明周期的时候来调用我们自定义的初始化和销毁方法
 *
 * 构造（对象创建）
 *          单实例：在容器启动的时候创建对象
 *          多实例：在每次获取的时候创建对象
 *
 * BeanPostProcessor.postProcessBeforeInitialization
 * 初始化：
 *        对象创建完成，并赋值好，调用初始化方法...
 * BeanPostProcessor.postProcessAfterInitialization
 *
 *
 *   遍历得到容器中所有的BeanPostProcess；挨个执行BeforeInitialization，
 * 一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessors
 *  BeanPostProcessor原理：
 *  populateBean(beanName,mbd,instanceWrapper);给bean进行属性赋值（get,set方法）
 *   {
 *       applyBeanPostProcessorsBeforeInitialization
 *       invokeInitMethods;执行初始化
 *       applyBeanPostProcessorsAfterInitialization
 *   }
 *
 *
 *
 * 销毁：
 *      单实例：容器关闭的时候
 *      多实例：容器不会管理这个bean；容器不会调用销毁方法
 * 1、指定初始化和销毁方法：
 *      指定init-method和destroy-method=""
 * 2、通过让Bean实现InitializingBean（定义初始化逻辑），
 *                 DisposableBean（定义销毁逻辑）
 * 3、可以使用JSR250:
 *      @PostConstruct ：在bean创建完成并且属性赋值完成；来执行初始化方法
 *      @PreDestroy ：在容器销毁bean之前通知进行清理工作
 * 4、BeanPostProcessor [interface]：bean的后置处理器（配置完成后对容器中的所有bean都有效）
 *      在bean初始化前后进行一些处理工作：
 *      postProcessBeforeInitialization：在初始化之前工作
 *      postProcessAfterInitialization：在初始化之后工作
 *      作用就是对容器中的所有bean在初始化前后进行处理，两个方法的返回值可以是原来的bean，也可以是加工之后的bean
 *
 *  Spring底层对BeanPostProcessor的使用
 *
 *
 *
 */
@ComponentScan("com.springboot.bean")
@Configuration
public class MainConfigOfLifeCycle {
    @Scope(value = "prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }


}
