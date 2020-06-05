package com.springboot.bean;

import org.springframework.stereotype.Component;

@Component
public class MyUser {

    public MyUser(){

    }

    private String name;
    private String age;

    @Override
    public String toString() {
        return "MyUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
