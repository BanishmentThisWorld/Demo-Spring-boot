package com.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author yc
 * @create 2020-04-17-16:53
 */

public class HelloService {
    // 在线修改 不让你改
    // 测试文字 这个
    private String name;

    public String getName() {
        return "得到了HelloService";
    }

    public void setName(String name) {
        this.name = name;
    }
}
