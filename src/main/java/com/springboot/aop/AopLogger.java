package com.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopLogger {

    /*
         execute(* com.springboot.config.*.*(..))
      解释：  第一个* 是表示所有返回值
        com.springboot.config 表示这个包
        .* 所有class    .*所有方法   (..) 所有参数
        都会执行
     */
    @Pointcut("execution(* com.springboot.config.*.*(..))")
    public void executeServiceMethod(){

    }

    @Before("executeServiceMethod()")
    public void beforeExcute(JoinPoint jp){
        System.out.println("前置增强");
    }

    @After("executeServiceMethod()")
    public void afterExecute(JoinPoint jp){
        System.out.println("后置增强");
    }

    @Around("executeServiceMethod()")
    public Object aroundExecute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕增强 执行前");
        Object result = pjp.proceed();
        System.out.println("环绕增强  执行后");
        return  result;
    }

}
