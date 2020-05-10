package com.springboot.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Factory;

/**
 * @author yc
 * @create 2020-04-28-13:30
 */
//创建一个Spring定义的FactoryBean
public class ColorFactory implements FactoryBean<Color> {

    //返回一个Color对象，这个对象会添加到容器
    //工厂bean获取的是调用getObject创建的对象，如果想获得FactoryBean本身:getBean("&FactoryBeanName")
    @Override
    public Color getObject() throws Exception {
        Color color = new Color();
        System.out.println("Color  "+color.hashCode());
        return color;
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    //是单例？
    //true：这个bean是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean
    @Override
    public boolean isSingleton() {
        return false;
    }
}
