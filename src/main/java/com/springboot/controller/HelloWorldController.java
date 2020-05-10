package com.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yc
 * @create 2020-04-12-15:56
 */
@RestController
public class HelloWorldController {

    @Value("${person.name}")
    private String name;

    @RequestMapping("/hello")
    public String Hello()
    {
        return "Hello World!"+name;
    }
}
