package com.springboot;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.springboot.bean.BeanTests;
import com.springboot.bean.Color;
import com.springboot.bean.MyUser;
import com.springboot.bean.Person;
import com.springboot.config.MainConfig2;
import com.springboot.config.MainConfigOfLifeCycle;
import com.springboot.config.MainConfigOfPropertyValues;
import com.springboot.dao.IUerDao;
import com.springboot.service.HelloService;

import org.apache.catalina.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.ApplicationContextTestUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * SpringBoot单元测试
 * 可以在测试期间自动注入
 */

@SpringBootTest

class ApplicationTests {

    @Autowired
    Person person;
    @Autowired
    BeanTests beanTests;
    @Autowired
    ApplicationContext ioc;

    @Test
    void testHelloService()
    {
      //   HelloService a =(HelloService) ioc.getBean(HelloService.class);
      //  System.out.println(a.getName());


        String[] definitionNames= ioc.getBeanDefinitionNames();
        for (String name : definitionNames)
        {
            System.out.println(name);
        }
    }


    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Test
    void beanTest()
    {
        System.out.println(beanTests.toString());
    }

    @SuppressWarnings("resource")
    @Test
    void testComponentScan()
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        Map<String,Person> personMap= applicationContext.getBeansOfType(Person.class);
        System.out.println(personMap);

       ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //  获取环境变量 windows 10
       String property= environment.getProperty("os.name");
        System.out.println(property);
//        Person person = (Person) applicationContext.getBean("person02");
//        System.out.println(person);
//        for (String name:definitionNames)
//        {
//            System.out.println(name);
//        }

    }

    @Test
    void testCanditional()
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] nameForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : nameForType)
        {
            System.out.println(name);
        }
        Map<String,Person> personMap = applicationContext.getBeansOfType(Person.class);
        System.out.println(personMap);
    }

    @Test
    void testImport(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println(name);
        }
    }

    @Test
    void testFactoryBean(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        Object colorFactory = applicationContext.getBean("&colorFactory");
        System.out.println("colorFactory的类是："+colorFactory.getClass());
        Object colorFactory2 = applicationContext.getBean("colorFactory");
        Object colorFactory3 = applicationContext.getBean("colorFactory");
        Object a = applicationContext.getBean("com.springboot.bean.Color");
        System.out.println("color是"+a.toString());
        System.out.println("color是"+a.hashCode());

    }

    @Test
    void testBeanLifeCycle() throws InterruptedException {
        //1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
        //applicationContext.getBean("car");
        //Thread.sleep(10000);
        applicationContext.close();

    }

    @Test
    void testPropertyValues(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println(name);
        }
        System.out.println("=================");
        Person person =(Person) applicationContext.getBean("personValues");
        System.out.println(person);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String name = environment.getProperty("person.name");
        System.out.println("环境变量name："+name);

        applicationContext.close();

    }

    @Test
     void testMybatis() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("MyBatis.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产 SqlSession对象
        SqlSession session = factory.openSession();
        //4. 使用 SqlSession 创建 Dao 接口的代理对象
        IUerDao uerDao = session.getMapper(IUerDao.class);
        //5. 使用代理对象执行方法
        List<MyUser> users = uerDao.findAll();
        for (MyUser mu : users){
            System.out.println(mu);
        }
        //6. 释放资源
        session.close();
        in.close();
    }

}





