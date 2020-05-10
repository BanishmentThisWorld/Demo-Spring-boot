package com.springboot.config;

import com.springboot.service.HelloService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author yc
 * @create 2020-04-18-15:56
 */

/**
 * 指明当前类是一个配置类，来替代之前的Spring配置文件
 */
@Configuration
@ComponentScans(value={
        @ComponentScan(value = "com.springboot",includeFilters =
                {
//                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class, Controller.class}),
                        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyFilterType.class)
                },useDefaultFilters = false)
})
@Lazy
public class MyAppConfig {

    //将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
//    @Bean
//    public HelloService helloService()
//    {
//        return new HelloService();
//    }
}
