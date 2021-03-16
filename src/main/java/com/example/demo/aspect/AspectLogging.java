package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectLogging {

    @Before("execution(* com.example.demo.service.*.*(..))")
    public void beforeAdvise(JoinPoint jp)
    {
        System.out.println("Before Aspect for " + jp.getSignature().getName());
    }
}
