package com.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yc
 * @create 2020-04-15-19:00
 */

/**
 * 将配置文件(application.yml)中配置的每一个属性的值，映射到这个组件中
 * 使用@ConfigurationProperties，告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
 * prefix = "persion"，配置文件中哪个下面的所有属性进行一一映射
 * 只有这个组件是容器中的组件，才能使用容器中的 @ConfigurationProperties(prefix = "persion") 功能
 *
 * */
@Component
@ConfigurationProperties(prefix = "person")
@PropertySource(value = {"classpath:person.properties"})
@Validated  //对数据进行校验，数据异常会统一抛出异常
public class Person {


   // @Value("${person.name}")
    //@Value("马云")
  // @Value("${person.name}")
    @Value("${person.name}")
    private String name;
  //  @Value("#{23*5}")
   // @Value("50")
    @Value("${person.age}")
    private Integer age;
   // @Value("false")
    private Boolean boss;
  //  @Value("${person.birth}")
    private Date birth;
   // @Value("${person.maps}") 复杂类型不能使用@Value
    private Map<String,Object> maps;
    //@Value("${person.lists}") 复杂类型不能使用@Value
    private List<Object> lists;

    public Person() {
    }

    public Person(String name, Integer age, Boolean boss) {
        this.name = name;
        this.age = age;
        this.boss = boss;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                '}';
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
